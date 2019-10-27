package csms.user;

public class User {
	static int num = 0;
	private int id;
	private String name;
	
	public User(String name) {
		this.name = name;
		id = num + 1;
		num++;
	}
	
	public int GetId()
	{
		return id;
	}
	
	public String GetName()
	{
		return name;
	}
	
	public void ShowData()
	{
		System.out.println("(ID="+id+", Name="+name+")");
	}
}
