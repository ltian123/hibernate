package day04;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import day01.Person;

public class TestSQLQuery {
	public static void main(String[] args) {
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
			
//			String sql=new StringBuffer()
//				.append("select * ")
//				.append("from t_person ")
////				.append("where name=? ")
//				.append("where name=:name ")
//				.toString();
//			
////			List<Object[]> persons=session.createSQLQuery(sql)
////										  .list();
//			
//			List<Person> persons=session.createSQLQuery(sql)
//										.addEntity(Person.class)
////										.setString(0, "bbb")
//										.setString("name", "bbb")
//										.setFirstResult(0)
//										.setMaxResults(6)
//					  				    .list();
			
			List persons=session.getNamedQuery("selectAll")
								.list();
			
			System.out.println(persons);
			
//			for (Object[] objects : persons) {
//				System.out.println(Arrays.toString(objects));
//			}
			

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
	}
}
