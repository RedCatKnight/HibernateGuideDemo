package com.yunfeic.test.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yunfeic.test.entity.Dict;

public class AppConfig {
	public static void main(String[] args) {
		//https://www.boraji.com/hibernate-5-hikaricp-configuration-example
		SessionFactory sessionFactory=SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Dict d1=new Dict("2","a", "之按时发生行", "73大城市87", "-1");
//		Dict d2=(Dict) session.get(Dict.class, "2");
		session.createSQLQuery("select * from dict").list();
		session.update(d1);
//		System.out.println(d2.getDictId());
//		System.out.println(d2.getDictItem());
		
//		List<Dict> l=session.createCriteria(Dict.class).list();

		trans.commit();
		
		session.close();
		sessionFactory.close();
//		for (Dict d : l) {
//			System.out.println(d.toString());
//		}
		
	}
}
