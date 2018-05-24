package shop;

import java.util.Set;

import org.hibernate.Session;

import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		Order order=selectByNo("123465789");
		
		System.out.println(order.getUser().getUsername()+"用户"+order.getNo()+"订单");
		System.out.println("---------------------------------");
		System.out.println("序号\t商品\t数量\t价格");
		Set<Item> items=order.getItems();
		int i=1;
		for (Item item : items) {
			System.out.println((i++)+"\t"+item.getProduct().getName()+"\t"+item.getNum()+"\t"+item.getPrice());
		}
		System.out.println("---------------------------------");
		System.out.println("共"+order.getCount()+"条\t\t总计："+order.getPrice()+"元");
	}
	
	public static Order selectById(Integer id){
		Order order=null;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
			order=(Order) session.get(Order.class, id);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		return order;
	}
	
	public static Order selectByNo(String no){
		Order order=null;
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();

			String hql=new StringBuffer()
				.append("from Order o ")
				.append("left join fetch o.user u ")
				.append("left join fetch o.items i ")
				.append("left join fetch i.product p ")
				.append("where o.no=:no ")
				.toString();
			
			order=(Order) session.createQuery(hql)
								 .setString("no", no)
								 .uniqueResult();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		return order;
	}
}
