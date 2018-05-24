package day04;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import day01.Person;

public class TestCriteria {
	public static void main(String[] args) {
		
		Person p=new Person();
//		p.setName("bbb");
//		p.setSex(true);
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();

//			List<Person> persons=session.createCriteria(Person.class)
//										.add(Restrictions.eq("name", "bbb"))
//										.list();
			
			
//			List<Person> persons=session.createCriteria(Person.class)
//										.add(Example.create(p))
//										.list();
			
			
			
			
			Criteria criteria=session.createCriteria(Person.class);
			
			if(p.getName()!=null&&!"".equals(p.getName())){
				criteria.add(Restrictions.like("name", "%"+p.getName()+"%"));
			}
			
			if(p.getSex()!=null){
				criteria.add(Restrictions.eq("sex", p.getSex()));
			}
			
			List<Person> persons=criteria.list();
			
			
			
			
			
			
			
			
			
			System.out.println(persons);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		
	}
}
