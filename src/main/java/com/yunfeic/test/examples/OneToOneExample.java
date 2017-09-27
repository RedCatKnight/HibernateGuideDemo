package com.yunfeic.test.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yunfeic.test.entity.Card;
import com.yunfeic.test.entity.Person;
import com.yunfeic.test.utils.SessionFactoryUtil;

public class OneToOneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		onlyDeleteCard();
	}
	
	/**
	 * 同时添加Person和Card,保存Person就会保存Card
	 */
	public static void add(){
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Person p=new Person(0, "张三");
		Card c=new Card("4320088979323");
		//为Person设置Card,使其关联Card,在保存Person时才会Card
		p.setC(c);
		//为Card设置Person,使其在被级联保存时,从属性p中获得需要插入数据库的主键ID,否则无法插入
		c.setP(p);
		session.save(p);
		
		trans.commit();
		Person person=(Person) session.get(Person.class, 0);
		
		session.close();
		sessionFactory.close();
		
		Card card=person.getC();
		System.out.println("添加的Person "+person.getPid()+"=="+person.getPname());
		System.out.println("添加的Card "+card.getCid()+"=="+card.getCname());
	}
	
	/**
	 * 同时删除Person和Card,删除Person就会删除Card
	 */
	public static void delete() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Person person = (Person)session.get(Person.class, 0);
		session.delete(person);
		
		trans.commit();
		Person p = (Person)session.get(Person.class, 0);
		session.close();
		sessionFactory.close();
		System.out.println("删除后Person "+p);
	}
	
	/**
	 * 给已存在的主键id的人添加一张卡
	 */
	public static void addCard() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		//假设数据库已存在主键1，给1号id的人添加一张卡
		Person person = (Person)session.get(Person.class, 1);
		Card c=new Card("4320088979323");
		person.setC(c);
		c.setP(person);
		session.save(person);
		trans.commit();
		
		Person p=(Person) session.get(Person.class, 1);
		session.close();
		sessionFactory.close();
		
		System.out.println("添加卡后的Person "+p.getPid()+"=="+p.getPname());
		System.out.println("添加的Card "+p.getC().getCid()+"=="+p.getC().getCname());
	}
	
	
	/**
	 * 只删除某个人的卡,要让session中的人不认识卡就可以删除
	 * Card与Person要主动互相解除关联,否则报错
	 * org.hibernate.ObjectDeletedException: deleted object would be re-saved by cascade
	 * 报错原因是session中已关联Person与Card，如果不互相解除关联，Person会重新级联保存Card,而这时又要删除Card,冲突
	 */
	public static void onlyDeleteCard() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		//假设数据库已存在主键1
		Person person = (Person)session.get(Person.class, 1);
		Card c=person.getC();
		//Card要主动与Person解除关联
		c.setP(null);
		//Person要主动与Card解除关联
		person.setC(null);
		session.delete(c);
		trans.commit();
		
		Person p=(Person) session.get(Person.class, 1);
		session.close();
		sessionFactory.close();
		System.out.println("删除卡后的Person的Card "+p.getC());
	}
}
