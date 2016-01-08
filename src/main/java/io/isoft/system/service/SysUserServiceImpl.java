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
import io.isoft.system.domain.SysMenu;
import io.isoft.system.domain.SysRole;
import io.isoft.system.domain.SysRoleMenu;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component("sysUserService")
@Transactional
public class SysUserServiceImpl implements SysUserService {

    @PersistenceContext
    private EntityManager entityManager;
    private final SysUserRepository sysUserRepository;
    private final SysRoleRepository sysRoleRepository;
    private final SysUserRoleRepository sysUserRoleRepository;
    private final SysMenuRepository sysMenuRepository;
    private final SysRoleMenuRepository sysRoleMenuRepository;

    @Autowired
    public SysUserServiceImpl(SysUserRepository sysUserRepository, SysUserRoleRepository sysUserRoleRepository,
                              SysRoleRepository sysRoleRepository, SysMenuRepository sysMenuRepository,
                              SysRoleMenuRepository sysRoleMenuRepository) {
        this.sysUserRepository = sysUserRepository;
        this.sysUserRoleRepository = sysUserRoleRepository;
        this.sysRoleMenuRepository = sysRoleMenuRepository;
        this.sysRoleRepository = sysRoleRepository;
        this.sysMenuRepository = sysMenuRepository;
    }

    @Override
    public MyFilterResult getSysUsers(MyFilter filter) {
        // TODO Auto-generated method stub
        try {
            FilterBuilder filterBuilder = new FilterBuilder();

            String hql = " from SysUser e ";
            if (filter.arguments.size() > 0)
                hql += " WHERE " + filterBuilder.buildHql(filter, "e");

            //排序之前生成一个count语句;
            Query countQuery = entityManager.createQuery("select count(*) " + hql);
            if (filter.sorts.size() == 0)
                hql += " ORDER BY e.autoId";
            else {
                //高级表格传多个排序字段;
                hql += " ORDER BY ";
                int sortIndex = 0;
                for (MyFilterSort myFilterSort : filter.sorts) {
                    hql += String.format("  e.%s %s %s", myFilterSort.sortColumn, myFilterSort.isAscending ? "" : "DESC", (++sortIndex == filter.sorts.size()) ? "" : ",");
                }

            }
            //现在生成实际的查询语句
            Query query = entityManager.createQuery(hql);

            //向总数query，实际query添加参数
            for (ObjectParameter parameter : filterBuilder.parameters) {
                if (parameter.fieldName.equals("amount")) {
                    //blazeDs 将value看做int值传来, 但我们需要的是 big decimal
                    parameter.value = new BigDecimal((Integer) parameter.value);
//					parameter.value = (String)parameter.value;
                }
                if (parameter.fieldName.equals("tradePrice")) {
                    parameter.value = new Double(parameter.value.toString());
                }

                query.setParameter(parameter.name, parameter.value);
                countQuery.setParameter(parameter.name, parameter.value);
            }
            Object o = countQuery.getSingleResult();
            int recordCount = Integer.parseInt(o.toString());
            int pageStart = (filter.pageIndex) * filter.pageSize;
            List<StaffDict> results = query.setFirstResult(pageStart).setMaxResults(filter.pageSize).getResultList();

            return new MyFilterResult((ArrayList<StaffDict>) results, recordCount);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @Override
    public SysUser getSysUser(String userCode) {
        // TODO Auto-generated method stub
        Assert.notNull(userCode, Constant.USER_CODE_NOT_NULL);
        return sysUserRepository.findByUserCode(userCode);
    }

    @Override
    public SysUser getSysUser(Map<String, String> params) {
        // TODO Auto-generated method stub

        String userCode = params.get("userCode");
        Assert.notNull(userCode, Constant.USER_CODE_NOT_NULL);
        SysUser user = sysUserRepository.findByUserCode(userCode);
        Assert.notNull(user, Constant.USER_CODE_NOT_EXIST);
        Assert.notEmpty(user.getRoles(), Constant.USER_HASNT_ROLES);
        String roleCode = params.get("roleCode");
        if (roleCode == null)
            return user;

        String password = params.get("password");
        if (password != null & !"".equals(password)) {
            String _pwd = user.getPassword();
            Assert.notNull(_pwd, Constant.USER_HASNT_PWD);
            String pwd = SupSafe.getEncrypt(password);
            Assert.isTrue(pwd.equals(_pwd), Constant.USER_PWD_ERROR);
            //根据roleCode 过滤对应的菜单
            List<SysRole> roles = user.getRoles();
            roles = roles.stream().filter(r->r.getRoleCode().equals(roleCode)).collect(Collectors.toList());
            user.setUserRoles(roles);
            return user;
        }
        //密码加密
        return null;
    }
}
