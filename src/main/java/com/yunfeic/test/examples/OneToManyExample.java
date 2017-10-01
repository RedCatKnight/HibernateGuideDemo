package com.yunfeic.test.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yunfeic.test.entity.Cateries;
import com.yunfeic.test.entity.Products;
import com.yunfeic.test.utils.SessionFactoryUtil;

public class OneToManyExample {

	public static void main(String[] args) {
		saveProductToExistCate();
	}
	
	/**
	 * 保存1个类别与2个产品,互相设置关系
	 */
	public static void saveCateriesAndProduct() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Cateries c=new Cateries(4, "军火", "枪炮...");
		Products p1=new Products("枪", 3242, "", "");
		Products p2=new Products("大炮", 32742, "", "");
		c.getPros().add(p1);
		c.getPros().add(p2);
		p1.setCatery(c);
		p2.setCatery(c);
		
		session.save(c);
		
		trans.commit();
		session.close();
		sessionFactory.close();
	}
	
	
	/**
	 * 删除类别或产品，首先先查出类别或产品对象,不需解除关系,直接删除,hibernate在one-to-many
	 * 时候执行删除只会删除当前对象,不会级联删除,否则性能很慢(例如,我删一个还得删级联的1000个，这样不可取),
	 * lazy指是否延迟加载目标对象的所有关联对象,默认延迟加载,除非把lazy设为false,才会即时加载所有关联对象
	 * ,否则只会有所有关联对象主键ID;
	 */
	public static void deleteCateOrProduct() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Products p=(Products) session.get(Products.class, "0011");
		session.delete(p);
		
		trans.commit();
		session.close();
//		System.out.println(p.getCatery().getCateryId());
		sessionFactory.close();
	}
	
	/**
	 * 为2号类别添加2个产品
	 */
	public static void saveProductToExistCate() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		Cateries cate=(Cateries) session.get(Cateries.class, 2);
		Products p1=new Products("苹果电脑", 5242, "", "");
		Products p2=new Products("联想电脑", 22742, "", "");
//		cate.getPros().add(p1);
//		cate.getPros().add(p2);
		p1.setCatery(cate);
		p2.setCatery(cate);
		session.save(p1);
		session.save(p2);
		trans.commit();
		session.close();
		sessionFactory.close();
	}
	
	
}
