package cms.group;

import cms.show.Showable;

public class GroupManager implements Showable{
	Group[] garr = new Group[50];
	private int index = 0;
	
	public void addGroup(String name)
	{
		garr[index++] = new Group(name);
	}
	
	@Override
	public void showData()
	{
		System.out.println("=====================");
		System.out.println("Group ID	Group ¿Ã∏ß");
		System.out.println("=====================");
		for(int i = 0 ; i<index; i++) {
			garr[i].ShowData();
		}
		System.out.println("=====================");
	}
	
	public String findTitleById(int id) {
		for(int i = 0 ; i < index ; i++) {
			if( garr[i].getId() == id) {
				return garr[i].getTitle();
			}
		}
		return null;
	}
}
