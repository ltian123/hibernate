package day01;

import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		Person p=new Person();
		p.setName("bbb");
		p.setBirthday(java.sql.Date.valueOf("2009-11-15"));
		p.setSex(false);
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
//			Transaction tran1=session.beginTransaction();
//			Transaction tran2=session.getTransaction();
//			tran2.begin();
//			Transaction tran3=session.getTransaction();
			
			session.save(p);
			
//			Transaction tran4=session.getTransaction();
//			
//			System.out.println(tran1);
//			System.out.println(tran2);
//			System.out.println(tran3);
//			System.out.println(tran4);
			
			session.getTransaction().commit();
			
//			Transaction tran5=session.getTransaction();
//			System.out.println(tran5);
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
//		Configuration cfg=new Configuration();
//		cfg.configure();
////		cfg.configure("xxx/xxx.xml");
//		
//		SessionFactory sf=cfg.buildSessionFactory();
//		
//		Session session=sf.openSession();
//		
//		session.beginTransaction();
//		
//		session.save(p);
//		
//		session.getTransaction().commit();
//		
//		session.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
