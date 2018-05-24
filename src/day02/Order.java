package day02;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Order implements Serializable {
	private Integer id;
	private String no;
	private Set<Item> items=new HashSet<Item>();
	private Integer count;
	public Order() {
		super();
	}
	public Order(Integer id, String no, Long count) {
		super();
		this.id = id;
		this.no = no;
		this.count = count.intValue();
	}
	public void addItem(Item item){
		items.add(item);
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
