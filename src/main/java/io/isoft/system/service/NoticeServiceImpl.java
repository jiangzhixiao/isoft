/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.isoft.system.service;

import io.isoft.SupSafe;
import io.isoft.base.constant.Constant;
import io.isoft.base.filter.*;
import io.isoft.reg.domain.StaffDict;
import io.isoft.system.domain.CdNotice;
import io.isoft.system.domain.SysRole;
import io.isoft.system.domain.SysUser;
import io.isoft.system.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("noticeService")
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @PersistenceContext
    private EntityManager entityManager;
    private final SysUserRepository sysUserRepository;

    @Autowired
    public NoticeServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    @Override
    public MyFilterResult findNotices(MyFilter filter) {
        try {
            FilterBuilder filterBuilder = new FilterBuilder();

            String hql = " from CdNotice e ";
            if(filter.arguments.size()>0)
                hql += " WHERE " + filterBuilder.buildHql(filter,"e");

            //排序之前生成一个count语句;
            Query countQuery = entityManager.createQuery("select count(*) " + hql);
            if (filter.sorts.size() == 0)
                hql += " ORDER BY e.noticeNo";
            else
            {
                //高级表格传多个排序字段;
                hql += " ORDER BY ";
                int sortIndex = 0;
                for(MyFilterSort myFilterSort : filter.sorts)
                {
                    hql += String.format("  e.%s %s %s", myFilterSort.sortColumn, myFilterSort.isAscending ? "" : "DESC",(++sortIndex == filter.sorts.size()) ? "" : ",");
                }

            }
            //现在生成实际的查询语句
            Query query = entityManager.createQuery(hql);

            //向总数query，实际query添加参数
            for(ObjectParameter parameter : filterBuilder.parameters){
                query.setParameter(parameter.name, parameter.value);
                countQuery.setParameter(parameter.name, parameter.value);
            }
            Object o = countQuery.getSingleResult();
            int recordCount = Integer.parseInt(o.toString()) ;
            int pageStart = (filter.pageIndex)*filter.pageSize;
            List<CdNotice> results = query.setFirstResult(pageStart).setMaxResults(filter.pageSize).getResultList();

            return new MyFilterResult((ArrayList<CdNotice>) results,recordCount) ;
        } catch (RuntimeException re) {
            throw re;
        }
    }
}
