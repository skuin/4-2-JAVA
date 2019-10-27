package csms.download;

import csms.item.Item;
import csms.user.User;

public class Download {
	static int num = 0;
	
	private int id;
	private int cost;
	
	private User user;
	private Item item;
	
	Download(User user, Item item){
		id = num + 1;
		this.user = user;
		this.item = item;
		
		this.cost = item.GetSize();
		num ++;
	}
	
	public int GetId()
	{
		return id;
	}
	
	public User GetUser()
	{
		return user;
	}
	
	public Item GetItem()
	{
		return item;
	}
	
	public String toString()
	{
		return  "(Download id="+id+", Name = "+user.GetName()+", Title = "+item.GetTitle()+", size = "+item.GetSize()+", "+"Cost = "+item.GetPrice()+")";
	}
}
