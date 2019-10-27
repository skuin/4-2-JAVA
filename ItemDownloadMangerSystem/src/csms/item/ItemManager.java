package csms.item;

import csms.show.Showable;

public class ItemManager implements Showable {

	private Item[] im = new Item[200];
	private int idx;
	
	public void addMovie(String name, int size, String director)
	{
		im[idx++] = new Movie(name, size, director);
	}
	
	public void addShow(String name, int size, String channel)
	{
		im[idx++] = new Show(name, size, channel);
	}
	
	public void addDrama(String name, int size, String channel)
	{
		im[idx++] = new Drama(name, size, channel);
	}
	
	@Override
	public void ShowAll()
	{
		for(int i=0;i<idx;i++) 
		{
			System.out.println(im[i]);
		}
	}
	
	public Item findItemByTitle(String title)
	{
		for(int i =0 ; i<idx; i++) {
			if(title==im[i].GetTitle()) {
				return im[i];
			}
		}
		return null;
	}
}
