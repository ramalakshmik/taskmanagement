package com.smi.tms.util;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class HibernateUtil {

	private static HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		HibernateUtil.hibernateTemplate = hibernateTemplate;
	}

	public static HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

}
