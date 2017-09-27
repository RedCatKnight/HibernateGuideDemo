package com.yunfeic.test.examples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yunfeic.test.entity.Suppliers;
import com.yunfeic.test.utils.SessionFactoryUtil;

public class OneToOneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 同时添加
	 */
	public static void add(){
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		

		trans.commit();
		session.close();
	}
	
}
