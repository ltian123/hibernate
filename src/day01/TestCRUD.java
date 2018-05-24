package day01;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import util.HibernateUtil;

public class TestCRUD {
	
	public static void main(String[] args) {
//		Person p=new Person();
//		p.setId(6);
//		p.setName("ccc");
////		p.setBirthday(java.sql.Date.valueOf("1999-01-01"));
//		p.setBirthday(new Date());
//		p.setSex(false);
//		p.setHobbies(new String[]{"吃","玩","睡"});
		
//		update(p);
		
//		insert(p);
//		
//		System.out.println(p.getId());
		
//		deleteById(1);
		
		
		Person p=selectById(3);
//		
//		System.out.println(p.getId());
//		System.out.println(p.getName());
//		System.out.println(p.getSex());
//		System.out.println(p.getBirthday());
//		System.out.println(p.getHob());
		
		
//		List<Person> persons=selectByHobby("玩");
//		
//		for (Person person : persons) {
//			System.out.println(person.getId()+"　"+person.getName()+" "+person.getSex()+" "+person.getBirthday()+" "+person.getHob());
//		}
		
//		updateNameById(9, "ddd");
		
//		updateBirthdayById(9, new Date());
		
//		select();
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void insert(Person p){
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
//			session.save(p);
//			
//			p.setName("bbb");
//			p.setBirthday(java.sql.Date.valueOf("1999-01-01"));
			
			session.saveOrUpdate(p);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	public static void deleteById(Integer id){
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
			Person p=new Person();
			p.setId(id);
			session.delete(p);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	public static void update(Person p){
		
		insert(p);
		
//		Session session = null;
//		try {
//			session = HibernateUtil.getSession();
//			session.beginTransaction();
//			
//			session.update(p);
//
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		} finally {
//			HibernateUtil.closeSession(session);
//		}
	}
	
	public static Person selectById(Integer id){
		Person p=null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
//			System.out.println("1111111111111111111111");
			
			p=(Person) session.get(Person.class, id);
			

			Person p2=(Person) session.get(Person.class, id);
			
			Person p3=(Person) session.get(Person.class, id);
			
			
			System.out.println(p);
			System.out.println(p2);
			System.out.println(p3);
			
//			p=(Person) session.load(Person.class, id);
//			System.out.println("2222222222222222222222");
//			System.out.println(p.getClass());
//			System.out.println(p.getName());
//			System.out.println("3333333333333333333333");
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		return p;
	}
	
	public static List<Person> selectAll(){
		List<Person> persons=new ArrayList<Person>();
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();

			String hql=new StringBuffer()
				.append("from Person ")
				.toString();
			
//			Query query=session.createQuery(hql);
//			persons=query.list();
			
			persons=session.createQuery(hql)
						   .setFirstResult(3)
						   .setMaxResults(4)
						   .list();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		
		return persons;
	}
	
	public static List<Person> selectAll(int pageNo,int maxSize){
		List<Person> persons=new ArrayList<Person>();
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();

			String hql=new StringBuffer()
				.append("from Person ")
				.toString();
			
//			Query query=session.createQuery(hql);
//			persons=query.list();
			
			persons=session.createQuery(hql)
						   .setFirstResult((pageNo-1)*maxSize)
						   .setMaxResults(maxSize)
						   .list();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		
		return persons;
	}
	
	
	
	
	public static List<Person> selectByName(String name){
		List<Person> persons=new ArrayList<Person>();
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
				
			String hql=new StringBuffer()
				.append("from Person p ")
//				.append("where p.name=? ")
				.append("where p.name=:name ")
				.toString();
			
			persons=session.createQuery(hql)
//						   .setString(0, name)
						   .setString("name", name)
						   .list();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		return persons;
	}
	
	//根据兴趣爱好查询Person，如找出爱好玩的人
	public static List<Person> selectByHobby(String hobby){
		List<Person> persons=new ArrayList<Person>();
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();

			String hql=new StringBuffer()
				.append("from Person p ")
				.append("where p.hob like :hobby ")
//				.append("where hobbies like :hobby ")
				.toString();
			persons=session.createQuery(hql)
						   .setString("hobby", "%"+hobby+"%")
						   .list();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		return persons;
	}
	
	
	public static void updateNameById(Integer id,String name){
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();

//			Person p=new Person();
//			p.setId(id);
//			p.setName(name);
//			session.update(p);
			
			Person p=(Person) session.get(Person.class, id);
			p.setName(name);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	public static void updateBirthdayById(Integer id,Date birthday){
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();

//			Person p=(Person) session.get(Person.class, id);
//			p.setBirthday(birthday);
//			session.update(p);
			
			String hql=new StringBuffer()
				.append("update Person p ")
				.append("set p.birthday=:birthday ")
				.append("where p.id=:id ")
				.toString();
			session.createQuery(hql)
				   .setDate("birthday", birthday)
				   .setInteger("id", id)
				   .executeUpdate();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
	
	
	public static void select(){
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();

			String hql=new StringBuffer()
//				.append("select p ")
//				.append("select p.id,p.name ")
//				.append("select new Person(p.id,p.name) ")
//				.append("select new day01.PersonVO(p.id,p.name) ")
//				.append("select new Map(p.id,p.name) ")
				.append("select new Map(p.id as id,p.name as name) ")
				.append("from Person p ")
				.toString();
			
//			List<Person> persons=session.createQuery(hql)
//										.list();
			
//			List<Object[]> persons=session.createQuery(hql)
//										  .list();
//			List<PersonVO> persons=session.createQuery(hql)
//										  .list();
			
			List<Map> persons=session.createQuery(hql)
									 .list();
			
			System.out.println(persons);
			
//			for (Person person : persons) {
//				System.out.println(person.getId()+"　"+person.getName()+" "+person.getSex()+" "+person.getBirthday()+" "+person.getHob());
//			}
			
//			for (Object[] objects : persons) {
//				System.out.println(Arrays.toString(objects));
//			}
			
//			for (PersonVO personVO : persons) {
//				System.out.println(personVO.getId()+" "+personVO.getName());
//			}
			
			for (Map map : persons) {
				System.out.println(map);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
	}
	
}










