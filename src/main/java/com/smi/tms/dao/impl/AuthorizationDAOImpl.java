package com.smi.tms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.smi.tms.dao.AuthorizationDAO;
import com.smi.tms.model.Authorization;
import com.smi.tms.util.HibernateUtil;

@Component
public class AuthorizationDAOImpl implements AuthorizationDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Authorization> getAuthorizationByRoleId(Integer roleId) {
		HibernateTemplate hibernateTemplate = HibernateUtil.getHibernateTemplate();
		return (List<Authorization>) hibernateTemplate.find("FROM Authorization where roleId=? and isActive=1", roleId);
	}

	@Override
	public void addAuthorizationList(List<Authorization> authList) {
		HibernateTemplate hibernateTemplate = HibernateUtil.getHibernateTemplate();
		
		authList.forEach( x -> {
			hibernateTemplate.saveOrUpdate(x);
		});
		
		
	}

	@Override
	public Authorization getAuthByMenuName(Integer roleId,String menu) {
		List<Authorization> list=new ArrayList<>();
		HibernateTemplate hibernateTemplate = HibernateUtil.getHibernateTemplate();
		list = (List<Authorization>) hibernateTemplate.find("FROM Authorization where menu=? Order by createdOn desc ", menu);
		if(list != null && list.size()>0) {
			return list.get(0);
		}
		else {
			return null;
		}
		
	}
	
	

}
