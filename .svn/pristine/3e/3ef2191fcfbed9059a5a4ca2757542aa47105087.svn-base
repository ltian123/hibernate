package day02;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import util.HibernateUtil;

public class TestOneToMany {
	public static void main(String[] args) {
//		Order order=new Order();
//		order.setNo("987654321");
//		
//		Item item1=new Item();
//		item1.setProduct("aaa");
//		item1.setNum(4);
//		
////		Item item2=new Item();
////		item2.setProduct("bbb");
////		item2.setNum(2);
//		
//		
//		Item item3=new Item();
//		item3.setProduct("ccc");
//		item3.setNum(2);
//		
//		item1.setOrder(order);
////		item2.setOrder(order);
//		item3.setOrder(order);
//		
//		order.addItem(item1);
////		order.addItem(item2);
//		order.addItem(item3);
		
		
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			
//			session.save(order);
//			session.save(item1);
////			session.save(item2);
//			session.save(item3);
			
//			Order order=(Order) session.get(Order.class, 1);
//			
//			System.out.println(order.getId()+"　"+order.getNo());
//			
//			Set<Item> items=order.getItems();
//			
//			for (Item item : items) {
//				System.out.println(item.getId()+" "+item.getProduct()+" "+item.getNum());
//			}
			
			
			
//			String hql=new StringBuffer()
//				.append("select distinct o ")
//				.append("from Order o ")
//				.append("join fetch o.items i ")
//				.toString();
//			
//			List<Order> orders=session.createQuery(hql)
//									  .list();
//			
//			System.out.println(orders);
//			
//			for (Order order : orders) {
//				System.out.println(order.getId()+"　"+order.getNo());
//				Set<Item> items=order.getItems();
//				for (Item item : items) {
//					System.out.println(item.getId()+" "+item.getProduct()+" "+item.getNum());
//				}
//			}
			
			String hql=new StringBuffer()
				.append("select new day02.Order(o.id, ")
				.append("                       o.no, ")
				.append("                       (select count(i) ")
				.append("                        from Item i ")
//				.append("                        where i.order.id=o.id)) ")
				.append("                        where i.order=o)) ")
				.append("from Order o ")
				.toString();
			
			
//			String hql=new StringBuffer()
//			.append("from Order o ")
//			.toString();
//		
			List<Order> orders=session.createQuery(hql)
									  .list();
			
			for (Order order : orders) {
				System.out.println(order.getId()+" "+order.getNo()+" "+order.getCount());
			}
			
			//找出买了aaa(商品名称)商品的所有订单
//			String hql=new StringBuffer()
//				.append("select distinct o ")
//				.append("from Order o ")
//				.append("join fetch o.items i ")
//				.append("where i.product=:product ")//集合中每一个元素的属性
//				.toString();
//			
//			
//			List<Order> orders=session.createQuery(hql)
//									  .setString("product", "aaa")
//									  .list();
//			
//			System.out.println(orders);
			
			
			
			
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.closeSession(session);
		}
		
		
		
		
		
	}
}
