package cn.itcast.bookstore.domain;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	
	private Map<String,CartItem> map=new HashMap();
	private double price;
	
	public void add(Book book, int quantity){		
	CartItem item=map.get(book.getBid());
	if(item==null)
	{	item=new CartItem();
		item.setBook(book);
		item.setQuantity(quantity);
		map.put(book.getBid(), item);		
	}else
	{
		item.setQuantity(item.getQuantity()+quantity);		
	}	
	}
	//清空所有条目
	public void clear(){
		map.clear();
	}
	//清空指定条目
	public void delete(String bid){
		map.remove(bid);
	}
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	public double getPrice() {
		double totalprice=0;
	for(Map.Entry<String, CartItem>me:map.entrySet()){
		CartItem item=me.getValue();
		totalprice=totalprice+item.getPrice();
	}
	this.price=totalprice;
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
