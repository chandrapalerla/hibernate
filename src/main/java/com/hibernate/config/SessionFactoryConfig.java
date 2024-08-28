package com.hibernate.config;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

	public static Session getSeesion() {
		Session openSession = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		return openSession;

	}

}
