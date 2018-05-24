package day04;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class TestComponent {
	public static void main(String[] args) {
//		People people=new People();
//		Name name=new Name();
//		name.setFirstName("aaa");
//		name.setLastName("bbb");
//		people.setName(name);
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
//			session.save(people);
			
			String hql=new StringBuffer()
				.append("from People p ")
				.append("where p.name.firstName=:firstName ")
				.toString();
			
			List<People> peoples=session.createQuery(hql)
										.setString("firstName", "aaa")
										.list();
										
			System.out.println(peoples);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
}
