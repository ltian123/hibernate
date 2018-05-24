package day02;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import util.HibernateUtil;

public class TestManyToOne {
	public static void main(String[] args) {
//		Dept dept=new Dept();
//		dept.setId(2);
////		dept.setName("d3");
//		
//		Emp emp=new Emp();
//		emp.setName("eee");
//		
//		emp.setDept(dept);
		
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
////			session.save(dept);
//			session.save(emp);
			
			
//			Emp emp=(Emp) session.get(Emp.class, 2);
//			
//			System.out.println(emp.getId()+"　"+emp.getName()+" "+emp.getDept().getId());
//			System.out.println(emp.getDept().getClass());
//			System.out.println(emp.getDept().getName());
			
			
//			String hql=new StringBuffer()
////				.append("select e ")
//				.append("from Emp e ")
//				.append("left join fetch e.dept d ")
//				.toString();
//			
//			List<Emp> emps=session.createQuery(hql)
//								  .list();
			
//			List<Object[]> emps=session.createQuery(hql)
//					  				   .list();
			
//			System.out.println(emps);
//			
//			for (Emp emp : emps) {
//				System.out.println(emp.getId()+"　"+emp.getName()+" "+emp.getDept().getId());
//				System.out.println(emp.getDept().getName());
//			}
			
//			for (Object[] objects : emps) {
//				System.out.println("------------------------------");
//				System.out.println(Arrays.toString(objects));
//				Emp emp=(Emp) objects[0];
//				Dept dept=(Dept) objects[1];
//				System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getDept());
//				System.out.println(dept.getId()+" "+dept.getName());
//				System.out.println("------------------------------");
//			}
			
			
			//找出d2（部门名称）部门的所有员工
//			String hql=new StringBuffer()
//				.append("select e ")
//				.append("from Emp e ")
//				.append("join e.dept d ")
//				.append("where d.name=:name ")
//				.toString();
			
//			String hql=new StringBuffer()
//				.append("from Emp e ")
//				.append("join fetch e.dept d ")
//				.append("where d.name=:name ")
//				.toString();
			
			
			String hql=new StringBuffer()
				.append("from Emp e ")
				.append("where e.dept.name=:name ")
				.toString();
			
			List<Emp> emps=session.createQuery(hql)
								  .setString("name", "d2")
								  .list();
			
			for (Emp emp : emps) {
				System.out.println(emp.getId()+"　"+emp.getName()+" "+emp.getDept().getId());
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
