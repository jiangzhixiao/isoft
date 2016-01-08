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

package io.isoft.blood.service;

import io.isoft.base.filter.*;
import io.isoft.blood.domain.BloodRdsMaster;
import io.isoft.blood.repository.RdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component("rdService")
@Transactional
public class RdServiceImpl implements RdService {

	@PersistenceContext
	private EntityManager entityManager;
	private final RdRepository rdRepository;
	@Autowired
	public RdServiceImpl(RdRepository rdRepository) {
		this.rdRepository = rdRepository;
	}

	@Override
	public MyFilterResult findByFilter(String autoId, MyFilter filter) {
		return null;
	}

	@Override
	public MyFilterResult findByFilter(MyFilter filter) {
		try {
			FilterBuilder filterBuilder = new FilterBuilder();

			String hql = " from BloodRdsMaster e ";
			if(filter.arguments.size()>0)
				hql += " WHERE " + filterBuilder.buildHql(filter,"e");

			//排序之前生成一个count语句;
			Query countQuery = entityManager.createQuery("select count(*) " + hql);
			if (filter.sorts.size() == 0)
				hql += " ORDER BY e.autoId";
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
				if(parameter.fieldName.equals("amount")){
					//blazeDs 将value看做int值传来, 但我们需要的是 big decimal
					parameter.value = new BigDecimal((Integer)parameter.value);
//					parameter.value = (String)parameter.value;
				}
				if(parameter.fieldName.equals("tradePrice")){
					parameter.value = new Double(parameter.value.toString());
				}

				query.setParameter(parameter.name, parameter.value);
				countQuery.setParameter(parameter.name, parameter.value);
			}
			Object o = countQuery.getSingleResult();
			int recordCount = Integer.parseInt(o.toString()) ;
			int pageStart = (filter.pageIndex)*filter.pageSize;
			List<BloodRdsMaster> results = query.setFirstResult(pageStart).setMaxResults(filter.pageSize).getResultList();

			return new MyFilterResult((ArrayList<BloodRdsMaster>) results,recordCount) ;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public MyFilterResult findByFilter(MyPrintExportFilter filter) {

		try {

			FilterBuilder filterBuilder = new FilterBuilder();

			String hql = " from BloodRdsMaster e ";
			if(filter.arguments.size()>0)
				hql += " WHERE " + filterBuilder.buildHql(filter,"e");

			//排序之前生成一个count语句;
//	        org.hibernate.Query hquery = query.unwrap(org.hibernate.Query.class);
			Query countQuery = entityManager.createQuery("select count(*) " + hql);
			//we need to always have some sort for paging to work
			if (filter.sorts.size() == 0)
				hql += " ORDER BY e.autoId";
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
				if(parameter.fieldName.equals("annualSalary")){
					//blazeDs 将value看做int值传来, 但我们需要的是 big decimal
					parameter.value = new BigDecimal((Integer)parameter.value);
				}

				query.setParameter(parameter.name, parameter.value);
				countQuery.setParameter(parameter.name, parameter.value);
			}
			int recordCount = Integer.parseInt(countQuery.getSingleResult().toString()) ;


			int pageStart = 0;
			int maxResult = 0;
			MyPrintExportOptions printExportOptions = filter.printExportOptions;
			String printExportOption = printExportOptions.getPrintExportOption();
			if(printExportOption.equals("All Pages")){
				pageStart = 0;// options.getPageFrom() * options.getPageTo();
				maxResult = filter.pageCount * filter.pageSize;
			}
			else if(printExportOption.equals("Selected Pages")){
				pageStart =(printExportOptions.getPageFrom() -1) * filter.pageSize;
				maxResult = filter.pageSize * (printExportOptions.getPageTo()-printExportOptions.getPageFrom()+1);
			}
			List<BloodRdsMaster> results = query.setFirstResult(pageStart).setMaxResults(maxResult).getResultList();

			return new MyFilterResult((ArrayList<BloodRdsMaster>) results,recordCount) ;
		} catch (RuntimeException re) {
			throw re;
		}

	}
}
