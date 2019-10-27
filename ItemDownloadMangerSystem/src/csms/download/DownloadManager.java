package csms.download;

import csms.user.User;
import csms.item.Item;
import csms.show.Showable;

public class DownloadManager implements Showable {
	static int num = 0;
	private Download[] d = new Download[300];
	
	public void addDownload(User user, Item item) 
	{
		d[num] = new Download(user, item);
		num++;
	}
	
	@Override
	public void ShowAll() 
	{
		for(int i=0;i<num;i++)
		{
			System.out.println(d[i]);
		}		
	}
}
