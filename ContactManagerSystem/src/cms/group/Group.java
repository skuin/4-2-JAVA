package cms.group;

public class Group {
	static int num = 0;
	private String title;
	private int id;
	
	Group(String title){
		id = num + 1;
		this.title = title;
		num++;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void ShowData() {
		System.out.println(id + "\t\t" + title);
	}
}
