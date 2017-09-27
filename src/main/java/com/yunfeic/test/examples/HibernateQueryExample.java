package com.yunfeic.test.examples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yunfeic.test.entity.Cateries;
import com.yunfeic.test.entity.Products;
import com.yunfeic.test.utils.SessionFactoryUtil;

public class HibernateQueryExample {
	public static void main(String[] args) {
		addCategory();
	}
	
	public static void addCategory() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Cateries c=new Cateries(4, "新型笔记本", null);
		session.save(c);
		trans.commit();
		session.close();
	}
}
