import java.util.Scanner;

import csms.item.ItemManager;
import csms.download.DownloadManager;
import csms.user.UserManager;

public class IDMS {
	Scanner s = new Scanner(System.in);

	UserManager um = new UserManager();
	ItemManager cm = new ItemManager();
	DownloadManager dm = new DownloadManager();
	
	int choice;

	void setDefault() {
	
		cm.addMovie("전쟁과 평화", 1000, "톨스토이");
		cm.addMovie("그해 겨울", 1100, "박완서");
		cm.addDrama("미스터선샤인1화",1200,"tvN");
		cm.addDrama("미스터선샤인2화",1300,"tvN");
		cm.addShow("한끼줍쇼 100회", 900, "jtbc");
		cm.addShow("걸어서 세계로 10회", 2000, "MDC");
		
		um.addUser("김일출");
		um.addUser("박일출");
		um.addUser("이일출");
		um.addUser("강일출");
		um.addUser("노일출");
		um.addUser("장일출");
		
		dm.addDownload(um.findUserByName("김일출"),cm.findItemByTitle("전쟁과 평화"));
		dm.addDownload(um.findUserByName("박일출"),cm.findItemByTitle("그해 겨울") );
		dm.addDownload(um.findUserByName("이일출"),cm.findItemByTitle("미스터선샤인1화"));
		dm.addDownload(um.findUserByName("강일출"),cm.findItemByTitle("미스터선샤인2화"));
		dm.addDownload(um.findUserByName("노일출"),cm.findItemByTitle("한끼줍쇼 100회"));
		dm.addDownload(um.findUserByName("장일출"),cm.findItemByTitle("걸어서 세계로 10회"));
	}
	
	void run()
	{

		while(true)
		{
			System.out.println("+---------Menu---------+");
			System.out.println("|1   Show all users    |");
			System.out.println("|2  Show all contents  |");
			System.out.println("|3  Show all downloads |");
			System.out.println("|0        Exit         |");
			System.out.println("+----------------------+");
			System.out.print("Your choice : >>"); choice = s.nextInt();
			
			switch(choice)
			{
			case 1:
				um.ShowAll();
				break;
			case 2:
				cm.ShowAll();
				break;
			case 3:
				dm.ShowAll();
				break;
			case 0:
				return;
			}
		}
	}
}
