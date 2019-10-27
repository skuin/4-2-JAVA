package csms.item;

public abstract class Item {
	static int num = 0;

	protected int id;
	protected String title;
	protected int size;

	Item(String title, int size){
		id = num + 1;
		this.title = title;
		this.size = size;
		num++;
	}
	
	public int GetSize()
	{
		return size;
	}
	
	public int GetId()
	{
		return id;
	}
	
	public String GetTitle()
	{
		return title;
	}
	
	public int GetPrice()
	{
		return charge(size);
	}
	
	public abstract String toString();

	public int charge(int size)
	{
		if(size<=1000)
		{
			return 1000;
		}
		else
		{
			return (size-1000)*1+1000;
		}
	}
}


class Movie extends Item{
	private String Director;
	Movie(String title, int size, String Director){
		super(title,size);
		this.Director = Director;
	}
	
	
	public String toString() {
		return "(ID="+id+", Movie, Title="+title+", Director="+Director+", price="+charge(size)+")";
	}
	
	@Override
	public int charge(int size)
	{
		if(size<=1000)
		{
			return 1000;
		}
		else
		{
			return (size-1000)*1+1000;
		}
	}
}

class Show extends Item{
	private String Channel;
	Show(String title, int size, String Channel){
		super(title,size);
		this.Channel = Channel;
	}
	
	
	public String toString() {
		return "(ID="+id+", Show, Title="+title+", Channel="+Channel+", price="+charge(size)+")";
	}
	
	@Override
	public int charge(int size)
	{
		if(size<=1000)
		{
			return 1000;
		}
		else
		{
			return (size-1000)*3+1000;
		}
	}
}


class Drama extends Item{
	private String Channel;
	Drama(String title, int size, String Channel){
		super(title,size);
		this.Channel = Channel;
	}
	
	public String toString() {
		return "(ID="+id+", Drama, Title="+title+", Channel="+Channel + ", price="+charge(size)+")";
	}
	
	@Override
	public int charge(int size)
	{
		if(size<=1000)
		{
			return 1000;
		}
		else
		{
			return (size-1000)*2+1000;
		}
	}
}
