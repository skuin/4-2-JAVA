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
	
		cm.addMovie("����� ��ȭ", 1000, "�罺����");
		cm.addMovie("���� �ܿ�", 1100, "�ڿϼ�");
		cm.addDrama("�̽��ͼ�����1ȭ",1200,"tvN");
		cm.addDrama("�̽��ͼ�����2ȭ",1300,"tvN");
		cm.addShow("�ѳ��ݼ� 100ȸ", 900, "jtbc");
		cm.addShow("�ɾ ����� 10ȸ", 2000, "MDC");
		
		um.addUser("������");
		um.addUser("������");
		um.addUser("������");
		um.addUser("������");
		um.addUser("������");
		um.addUser("������");
		
		dm.addDownload(um.findUserByName("������"),cm.findItemByTitle("����� ��ȭ"));
		dm.addDownload(um.findUserByName("������"),cm.findItemByTitle("���� �ܿ�") );
		dm.addDownload(um.findUserByName("������"),cm.findItemByTitle("�̽��ͼ�����1ȭ"));
		dm.addDownload(um.findUserByName("������"),cm.findItemByTitle("�̽��ͼ�����2ȭ"));
		dm.addDownload(um.findUserByName("������"),cm.findItemByTitle("�ѳ��ݼ� 100ȸ"));
		dm.addDownload(um.findUserByName("������"),cm.findItemByTitle("�ɾ ����� 10ȸ"));
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
