package day04;

import org.hibernate.Session;

import util.HibernateUtil;

public class TestOneToOne {
	public static void main(String[] args) {
		Engine engine=new Engine();
		engine.setName("e1");
		Car car=new Car();
		car.setName("c1");
		
		car.setEngine(engine);
		engine.setCar(car);
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
			session.save(car);
			session.save(engine);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
}
