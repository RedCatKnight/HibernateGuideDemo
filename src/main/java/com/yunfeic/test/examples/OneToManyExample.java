package com.yunfeic.test.examples;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yunfeic.test.entity.Cateries;
import com.yunfeic.test.entity.Products;
import com.yunfeic.test.utils.SessionFactoryUtil;

public class OneToManyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		List<Products> list = session.createQuery("select p from Products p").list();
		for (Products pro : list) {
			System.out.println(pro.getProductName() + "==" + pro.getProductNo());
		}

		trans.commit();
		session.close();
	}

}
