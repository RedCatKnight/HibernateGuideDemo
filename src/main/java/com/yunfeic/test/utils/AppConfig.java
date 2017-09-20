package com.yunfeic.test.utils;

import java.net.URL;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppConfig {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		URL url = AppConfig.class.getClassLoader().getResource("hibernate.cfg.xml");
		config.configure(url);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		//https://www.boraji.com/hibernate-5-hikaricp-configuration-example
		List l=session.createSQLQuery("select * from dict").list();
		trans.commit();
		session.flush();
		session.close();
		for (Object object : l) {
			System.out.println(object);
		}
		
	}
}
