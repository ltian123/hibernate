package day04;

import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class TestExtends {
	public static void main(String[] args) {
//		Manager manager=new Manager();
//		manager.setUsername("admin");
//		manager.setPassword("admin");
//		manager.setPhone("12345678");
//		
//		Member member=new Member();
//		member.setUsername("abc");
//		member.setPassword("123");
//		member.setEmail("a@a.com");
		
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();

//			session.save(manager);
//			session.save(member);
			
////			Manager manager=(Manager) session.get(Manager.class, 1);
//			Manager manager=(Manager) session.get(User.class, 1);
//			
//			System.out.println(manager);
//			System.out.println(manager.getId()+" "+manager.getUsername()+" "+manager.getPassword()+" "+manager.getPhone());
			
//			String hql=new StringBuffer()
//				.append("from Manager m ")
//				.toString();
//			
//			List<Manager> managers=session.createQuery(hql)
//										  .list();
//			
//			System.out.println(managers);
			
			String hql=new StringBuffer()
				.append("from User u ")
//				.append("from day04.User u ")
				.toString();
			
			List<User> users=session.createQuery(hql)
									.list();
			
			System.out.println(users);
			
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
}
