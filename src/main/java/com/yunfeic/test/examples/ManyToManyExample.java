package com.yunfeic.test.examples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yunfeic.test.entity.Suppliers;
import com.yunfeic.test.utils.SessionFactoryUtil;

public class ManyToManyExample {
	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		List<Suppliers> list = session.createQuery("select supply from Suppliers supply").list();
		for (Suppliers supply : list) {
			System.out.println(supply.getSupplyName() + "==" + supply.getSupplyNo());
		}

		trans.commit();
		session.close();
		sessionFactory.close();
	}
}
