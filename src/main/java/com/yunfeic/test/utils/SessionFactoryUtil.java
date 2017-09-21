package com.yunfeic.test.utils;

import java.net.URL;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	private static SessionFactoryUtil shareInstance=new SessionFactoryUtil();
	private SessionFactory sessionFactory;
	private StandardServiceRegistry serviceRegistry;
	
	private SessionFactoryUtil(){}
	
	public static SessionFactoryUtil getShareInstance(){
		return shareInstance;
		
	}
	
	
	public StandardServiceRegistry getServiceRegistry() {
		return serviceRegistry;
	}

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				Configuration config = new Configuration();
				URL url = SessionFactoryUtil.class.getClassLoader().getResource("hibernate.cfg.xml");
				config.configure(url);

				registryBuilder.applySettings(config.getProperties());

				serviceRegistry = registryBuilder.build();
//				MetadataSources sources = new MetadataSources(serviceRegistry).addAnnotatedClass(Dict.class);
//				Metadata metadata = sources.getMetadataBuilder().build();
//				sessionFactory = metadata.getSessionFactoryBuilder().build();
				sessionFactory = config.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				if (serviceRegistry != null) {
					StandardServiceRegistryBuilder.destroy(serviceRegistry);
				}
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

	public void shutdown() {
		if (serviceRegistry != null) {
			StandardServiceRegistryBuilder.destroy(serviceRegistry);
		}
	}
	
	
}
