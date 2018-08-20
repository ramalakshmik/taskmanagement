package com.smi.tms.util;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateUtil {
	
	public static HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		HibernateUtil.hibernateTemplate = hibernateTemplate;
	}


}
