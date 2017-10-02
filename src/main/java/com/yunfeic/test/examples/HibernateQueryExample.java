package com.yunfeic.test.examples;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.yunfeic.test.entity.Cateries;
import com.yunfeic.test.entity.Products;
import com.yunfeic.test.utils.SessionFactoryUtil;

public class HibernateQueryExample {
	public static void main(String[] args) {
		qbcQuerydemo();
	}

	public static void selectAllProducts() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Products> l = session.createQuery("select p from Products p").list();
		for (Products item : l) {
			System.out.println(item.getProductName() + "==类别" + item.getCatery().getCateryName());
		}
		session.close();
		sessionFactory.close();
	}

	/**
	 * 查询类别名字带惠字的
	 */
	public static void selectProductsByName() {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Products> l = session.createQuery("select p from Products p where p.productName like :productName")
				.setString("productName", "%" + "惠" + "%").list();
		for (Products item : l) {
			System.out.println(item.getProductName() + "==类别" + item.getCatery().getCateryName());
		}
		session.close();
		sessionFactory.close();
	}

	/**
	 * 查询类别是数码相机的产品
	 */
	public static void selectProductsByCate() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Products> l = session.createQuery("select p from Products p where p.catery.cateryName = :cateryName")
				.setString("cateryName", "数码相机").list();
		for (Products item : l) {
			System.out.println(item.getProductName() + "==类别" + item.getCatery().getCateryName());
		}
		session.close();
		sessionFactory.close();
	}

	/**
	 * HQL支持SQL的绝大部分的操作 例如： >,<,<=,>=,!=,and,or,not is null,in,between and等
	 * 另外也支持sql中的聚合函数 例如 max，min，avg，sum，count等 也支持sql中的子查询与表连接,排序，分组 还支持自己独有的方式
	 * 例如集合的size
	 */
	public static void selectCateByCondition() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println("查询多于3种产品的类别");
		List<Cateries> l = session.createQuery("select c from Cateries c where c.pros.size >= 3").list();
		for (Cateries item : l) {
			System.out.println("类别 " + item.getCateryName());
		}

		System.out.println("");
		System.out.println("查询最高的价格的产品");
		List<Products> list = session
				.createQuery(" from Products where productPrice=(select max(p.productPrice) from Products p)").list();
		for (Products item : list) {
			System.out.println("产品 " + item.getProductName() + " 价格 " + item.getProductPrice());
		}

		System.out.println("");
		System.out.println("查询价格在1000到9000之间带三字的产品");
		List<Products> list2 = session
				.createQuery(
						" from Products p where productPrice between :min and :max and p.productName like :productName")
				.setFloat("min", 1000).setFloat("max", 9000).setString("productName", "%" + "三" + "%").list();
		for (Products item : list2) {
			System.out.println("产品 " + item.getProductName() + " 价格 " + item.getProductPrice());
		}

		session.close();
		sessionFactory.close();
	}

	/**
	 * 推荐dto 查询所有产品的名称与价格与所属类别 使用dto(data transform object)或已有实体类接收查询结果
	 */
	public static void multiTableQuery() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println("用dto或以下object[]形式");
		List<Object> l = session.createQuery("select p.productName,p.productPrice,p.catery.cateryName from Products p")
				.list();
		for (Object item : l) {
			Object[] objs = (Object[]) item;
			for (Object object : objs) {
				System.out.print(object + "\t");
			}
			System.out.println("");
		}

		System.out.println("");
		System.out.println("用已有实体类");
		List<Products> l2 = session.createQuery("select new Products(p.productName,p.productPrice) from Products p")
				.list();
		for (Products item : l2) {
			System.out.println(item.getProductName() + " " + item.getProductPrice() + "\t");
		}

		session.close();
		sessionFactory.close();
	}

	/**
	 * 关于分页 setFirstResult（(pageNo-1)*pageSize） setMaxResults(pageSize)
	 */
	public static void paginationQuery() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println("查询第2页，每页3条");
		List<Products> l = session.createQuery("select p from Products p").setFirstResult(3).setMaxResults(3).list();
		for (Products item : l) {
			System.out.println("产品 " + item.getProductName());
		}

		session.close();
		sessionFactory.close();
	}

	/**
	 * 批处理 将类别id是4的所有产品删除
	 */
	public static void batchQuery() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		// 方法1
		session.createQuery("delete from Products p where p.catery.cateryId=:cateryId").setInteger("cateryId", 4)
				.executeUpdate();

		// 方法2
		// Cateries c=(Cateries) session.get(Cateries.class, 4);
		// session.createQuery("delete from Products p where
		// p.catery=:catery").setParameter("catery", c).executeUpdate();

		trans.commit();
		session.close();
		sessionFactory.close();
	}

	/**
	 * 批处理 将类别为2的所有产品转移到类别为1的下面
	 */
	public static void batchUpdate() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		// 方法1
		session.createQuery(
				"update from Products p set p.catery.cateryId=:newCateryId where p.catery.cateryId=:oldCateryId")
				.setInteger("oldCateryId", 2).setInteger("newCateryId", 1).executeUpdate();

		// 方法2,多执行了查询
		// Cateries c1 = (Cateries) session.get(Cateries.class, 1);
		// Cateries c2 = (Cateries) session.get(Cateries.class, 2);
		// session.createQuery("update from Products p set p.catery=:newCatery where
		// p.catery=:oldCatery")
		// .setParameter("newCatery", c1).setParameter("oldCatery", c2).executeUpdate();

		trans.commit();
		session.close();
		sessionFactory.close();
	}

	public static void qbcQuerydemo() {
		SessionFactory sessionFactory = SessionFactoryUtil.getShareInstance().getSessionFactory();
		Session session = sessionFactory.openSession();

		// 查所有产品
		session.createCriteria(Products.class).list();

		// 查名字带惠字的产品并且价格大于3000的
		session.createCriteria(Products.class).add(Restrictions.like("productName", "惠", MatchMode.ANYWHERE))
				.add(Restrictions.ge("productPrice", 3000f)).list();

		// 查询产品价格大于4000或者名字包含惠的产品，再按productPrice降序
		session.createCriteria(Products.class)
				.add(Restrictions.or(Restrictions.gt("productPrice", 4000f),
						Restrictions.like("productName", "惠", MatchMode.ANYWHERE)))
				.addOrder(Order.desc("productPrice")).list();

		// 查询产品数量等于3的类别
		session.createCriteria(Cateries.class).add(Restrictions.sizeEq("pros", 3)).list();

		// 查询笔记本类的所有产品
		List<Products> list = session.createCriteria(Products.class).createAlias("catery", "cate")
				.add(Restrictions.eq("cate.cateryName", "笔记本")).addOrder(Order.desc("productPrice")).list();

		for (Products products : list) {
			System.out.println(products.getProductName() + "==" + products.getProductPrice());
		}

		// 聚合查询或者分组查询需要使用投影
		// 查询最高的价格
		Criteria c1 = session.createCriteria(Products.class);
		// 投影
		Projection projection = Projections.max("productPrice");
		c1.setProjection(projection);
		Float max = (Float) c1.uniqueResult();
		System.out.println(max);

		// 查询每个类别最高的价格
		Criteria c = session.createCriteria(Products.class);
		c.createAlias("catery", "c");
		Projection maxprojection = Projections.max("productPrice");
		Projection groupprojection = Projections.groupProperty("c.cateryId");
		// 投影的集合对象
		ProjectionList plist = Projections.projectionList();
		plist.add(maxprojection);
		plist.add(groupprojection);
		List<Object> l = c.setProjection(plist).list();
		for (Object object : l) {
			Object[] objs = (Object[]) object;
			for (Object object2 : objs) {
				System.out.print(object2 + "\t");
			}
			System.out.println();
		}

		session.close();
		sessionFactory.close();
	}

}
