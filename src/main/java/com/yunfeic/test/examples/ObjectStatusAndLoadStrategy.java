package com.yunfeic.test.examples;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yunfeic.test.entity.Cateries;
import com.yunfeic.test.utils.SessionFactoryUtil;

/**
 * @author yunfeic
 *
 */
public class ObjectStatusAndLoadStrategy {

	public static void main(String[] args) {
		testEvict();

	}

	/**
	 * 测试即时加载get与懒加载load,报错org.hibernate.LazyInitializationException: could not
	 * initialize proxy - no Session
	 */
	public static void testLoadWay() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();

		// 测试即时加载get与懒加载load
		Cateries c1 = (Cateries) session.get(Cateries.class, 1);
		Cateries c2 = (Cateries) session.load(Cateries.class, 2);

		trans.commit();
		session.close();
		sessionFactory.close();
		System.out.println(c1.getCateryId() + "===" + c1.getCateryName());
		System.out.println(c2.getCateryId() + "===" + c2.getCateryName());
	}

	/**
	 * 测试session添加同一个对象,即把拥有相同主键的对象 从新建态转为持久化状态，但session中已有该持久化状态对象，
	 * session报错
	 * org.hibernate.NonUniqueObjectException: A different object with the same
	 * identifier value was already associated with the session :
	 * [com.yunfeic.test.entity.Cateries#3]
	 */
	public static void testNonUniqueObject() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Cateries cateries1 = new Cateries(3,"洗衣机", "");

		session.get(Cateries.class, 3);
		session.save(cateries1);
		trans.commit();
		session.close();
		sessionFactory.close();
	}

	
	/**
	 * 修改持久化状态对象的主键,session报错
	 * org.hibernate.HibernateException: identifier of an instance of 
	 * com.yunfeic.test.entity.Cateries was altered from 3 to 9
	 */
	public static void modifyKeyWhenPersistent() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Cateries cateries = (Cateries) session.get(Cateries.class, 3);
		cateries.setCateryId(2);
		trans.commit();
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * 重复保存持久态的对象,只会执行一次插入语句
	 */
	public static void reSavePersistentObject() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Cateries cateries1 = new Cateries(6,"洗衣机", "");

		session.save(cateries1);
		cateries1.setCateryName("鸟");
		session.save(cateries1);
		session.save(cateries1);
		session.save(cateries1);
		trans.commit();
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * evict将持久化对象从sesison踢出去，变为游离态,
	 * 然后设置另一个已存在的主键,再update,修改了这个已存在的主键的记录
	 */
	public static void testEvict() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Cateries cateries1 = (Cateries) session.get(Cateries.class, 2);
		
		session.evict(cateries1);
		//为其设置另一个已存在的主键
		cateries1.setCateryId(4);
		cateries1.setCateryName("彩电000");
		session.update(cateries1);
		
		trans.commit();
		session.close();
		sessionFactory.close();
	}
	
}
