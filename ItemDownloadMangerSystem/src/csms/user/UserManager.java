package csms.user;

import csms.show.Showable;

public class UserManager implements Showable {
	private User[] u = new User[100];
	private int idx;
	
	public void addUser(String name)
	{
		u[idx++] = new User(name);
	}
	
	@Override
	public void ShowAll()
	{
		for(int i = 0 ; i<idx; i++) {
			u[i].ShowData();
		}
	}
	
	public User findUserByName(String name) 
	{
		for(int i =0 ; i<idx ; i++) {
			if(name == u[i].GetName()) {
				return u[i];
			}
		}
		return null;
	}
}
