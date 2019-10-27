package midPrac;

import java.util.Scanner;

import cms.contact.ContactManager;
import cms.group.GroupManager;

public class CMS {
	ContactManager c = new ContactManager();
	GroupManager gm = new GroupManager(); 
	int n, gId;
	String name, email, group;
	String fName;
	String gName;
	Scanner scan = new Scanner(System.in);
	
	void setDefault() {
		gm.addGroup("����");
		gm.addGroup("��ģ��");
		gm.addGroup("�ʵ�ģ��");
		gm.addGroup("�ߵ�ģ��");
		gm.addGroup("���Ż�");
		gm.addGroup("����");
		gm.addGroup("�븮��");
	}
	
	void run() {
		while(true) {
	
			System.out.println("========�޴�=========");
			System.out.println("1. ����ó �߰�(���)");
			System.out.println("2. ����ó �߰�(ȸ��)");
			System.out.println("3. ����ó ��ȸ");
			System.out.println("4. ����ó ��� ���");
			System.out.println("5. ����ó �׷� �߰�");
			System.out.println("6. ����ó �׷� ��� ���");
			System.out.println("0. ����");
			System.out.println("===================");
			System.out.print("��ȣ �Է� ===> "); n = scan.nextInt();
			
			switch(n) {
			case 1:
				System.out.println("<< ����ó ���� �Է� >>");
				System.out.print("- �̸� : "); name = scan.next();
				System.out.print("- �̸��� : "); email = scan.next();
				gm.showData();
				System.out.print("- �׷� ID: "); gId = scan.nextInt();
				group = gm.findTitleById(gId);
				c.addContact(name, email, group);
				break;
			case 2:
				c.addContact2();
				break;
			case 3:
				System.out.print("- ã����� �̸� �Է� : ");
				fName = scan.next();
				c.findContactByName(fName);
				break;
			case 4:
				c.showData();
				break;
			case 5:
				System.out.print("- �߰��� �׷� �̸� : ");
				gName = scan.next();
				gm.addGroup(gName);
				break;
			case 6:
				gm.showData();
				break;
			case 0:
				return;
			}
		}
	}
}
