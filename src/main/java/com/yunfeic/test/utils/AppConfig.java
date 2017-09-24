package com.yunfeic.test.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yunfeic.test.entity.Card;
import com.yunfeic.test.entity.Dict;
import com.yunfeic.test.entity.Person;

public class AppConfig {
	public static void main(String[] args) {
		//https://www.boraji.com/hibernate-5-hikaricp-configuration-example
		SessionFactory sessionFactory=SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		//get load 方法区别
//		Dict d1=new Dict("2","a", "之按时发生行", "73大城市87", "-1");
//		Dict d2=(Dict) session.get(Dict.class, "2");
//		List<Dict> l=session.createCriteria(Dict.class).list();
//		session.update(d1);
//		System.out.println(d2.getDictId());
//		System.out.println(d2.getDictItem());
		
		//保持one-to-one对象
//		Person p=new Person();
//		Card c=new Card();
//		p.setPname("掌声2");
//		p.setC(c);
//		c.setP(p);
//		c.setCunm(2122245);
//		session.save(p);
//		session.save(c);
		
		//级联获取对象
//		Person p=(Person) session.get(Person.class, 2);
//		Card c=(Card) session.get(Card.class, 2);


//		System.out.println(p.getPid());
//		System.out.println(p.getPname());
//		System.out.println(p.getC().getCunm());
		
//		System.out.println(c.getCid());
//		System.out.println(c.getCunm());
//		System.out.println(c.getP().getPname());
		
		//删除操作
		Person p=(Person) session.get(Person.class, 2);
		session.delete(p);
		Person add=new Person();
		add.setPname("add");
		session.save(add);
		
		trans.commit();
		session.close();
		sessionFactory.close();
	}
}
