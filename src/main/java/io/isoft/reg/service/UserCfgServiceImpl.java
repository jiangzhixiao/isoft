package io.isoft.reg.service;

import io.isoft.base.filter.*;
import io.isoft.reg.domain.MonitorUsersConfig;
import io.isoft.reg.repository.WarnUserCfgRepo;
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

@Component("userCfgService")
@Transactional
public class UserCfgServiceImpl implements UserCfgService {

	@PersistenceContext
	private EntityManager entityManager; 
	private final WarnUserCfgRepo warnUserCfgRepo;
	
	@Autowired
	public UserCfgServiceImpl(WarnUserCfgRepo warnUserCfgRepo) {
		this.warnUserCfgRepo = warnUserCfgRepo;
	}
	@Override
	public MonitorUsersConfig addUserCfg(MonitorUsersConfig config) {
		// TODO Auto-generated method stub
		return warnUserCfgRepo.save(config);
	}

	@Override
	public MonitorUsersConfig getUserCfg(String autoId) {
		// TODO Auto-generated method stub
		Assert.notNull(autoId, "autoId 不能为空");
		return warnUserCfgRepo.findByAutoId(autoId);
	}

	@Override
	public MyFilterResult getUserCfg(MyFilter filter) {
		// TODO Auto-generated method stub
		try {
			FilterBuilder filterBuilder = new FilterBuilder();
			
	        String hql = " from MonitorUsersConfig e ";
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
    	        	hql += String.format("  e.%s %s %s", myFilterSort.sortColumn, myFilterSort.isAscending ? "" : 
    	        		"DESC",(++sortIndex == filter.sorts.size()) ? "" : ",");
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
			List<MonitorUsersConfig> results = query.setFirstResult(pageStart).setMaxResults(filter.pageSize).getResultList();
			
			return new MyFilterResult((ArrayList<MonitorUsersConfig>) results,recordCount) ;
		} catch (RuntimeException re) {
			throw re;
		}
	}

}
