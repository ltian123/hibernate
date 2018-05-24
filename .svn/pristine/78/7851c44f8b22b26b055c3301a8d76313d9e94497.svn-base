package day04;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;
import day01.Person;

public class TestQuery {
	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
			List<Person> persons=session.getNamedQuery("selectByName")
										.setString("name", "bbb")
										.setFirstResult(0)
										.setMaxResults(7)
										.list();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
}
