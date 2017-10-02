package com.yunfeic.test.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.yunfeic.test.entity.Cateries;
import com.yunfeic.test.utils.SessionFactoryUtil;

public class CacheExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		secondExternalLevelCache();
	}

	/**
	 * 一级缓存 session级别(hibernate自带的缓存)
	 */
	public static void firstLevelCache() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		// 只会执行一条查询,session会缓存结果
		session.get(Cateries.class, 1);
		session.get(Cateries.class, 1);

		session.close();
		sessionFactory.close();
	}

	/**
	 * 二级缓存 sessionfactory级别
	 */
	public static void secondLevelCache() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		// 只会执行一条查询,sessionFactory会缓存结果
		Session session1 = sessionFactory.openSession();
		session1.get(Cateries.class, 1);
		session1.close();

		Session session2 = sessionFactory.openSession();
		session2.get(Cateries.class, 1);
		session2.close();

		sessionFactory.close();
	}

	/**
	 * 一级查询缓存 对于查询而言缓存的key不是对象的主键,值也不是对应的对象; key而是sql语句,值是该sql语句查询出的集合
	 */
	public static void firstQueryLevelCache() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		// setCacheable(true)才能开启查询缓存 只会执行一条查询
		Session session = sessionFactory.openSession();

		session.createQuery("from Products").setCacheable(true).list();
		System.out.println("========");
		session.createQuery("from Products").setCacheable(true).list();

		session.close();
		sessionFactory.close();
	}

	/**
	 * 二级查询缓存
	 */
	public static void secondQueryLevelCache() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		// setCacheable(true)才能开启查询缓存 只会执行一条查询
		Session session1 = sessionFactory.openSession();
		// 执行查询查出所有放到页面
		session1.createQuery("from Cateries").setCacheable(true).list();
		session1.close();

		Session session2 = sessionFactory.openSession();
		session2.createQuery("from Cateries").setCacheable(true).list();
		session2.close();

		sessionFactory.close();
	}

	/**
	 * 一级外部缓存
	 * 
	 * @throws InterruptedException
	 */
	public static void firstExternalLevelCache() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		session.createQuery("from Cateries").setCacheable(true).setCacheRegion("mymaxcache").list();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("休眠完毕");
		session.createQuery("from Cateries").setCacheable(true).setCacheRegion("mymaxcache").list();

		session.close();
		sessionFactory.close();
	}

	/**
	 * 二级外部缓存
	 */
	public static void secondExternalLevelCache() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.createQuery("from Cateries").setCacheable(true).setCacheRegion("mymaxcache").list();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("休眠完毕");
		Session session2 = sessionFactory.openSession();
		session2.createQuery("from Cateries").setCacheable(true).setCacheRegion("mymaxcache").list();

		session2.close();
		sessionFactory.close();
	}

}
