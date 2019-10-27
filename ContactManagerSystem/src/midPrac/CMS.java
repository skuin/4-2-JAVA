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
		gm.addGroup("가족");
		gm.addGroup("과친구");
		gm.addGroup("초딩친구");
		gm.addGroup("중딩친구");
		gm.addGroup("구매사");
		gm.addGroup("고객사");
		gm.addGroup("대리점");
	}
	
	void run() {
		while(true) {
	
			System.out.println("========메뉴=========");
			System.out.println("1. 연락처 추가(사람)");
			System.out.println("2. 연락처 추가(회사)");
			System.out.println("3. 연락처 조회");
			System.out.println("4. 연락처 목록 출력");
			System.out.println("5. 연락처 그룹 추가");
			System.out.println("6. 연락처 그룹 목록 출력");
			System.out.println("0. 종료");
			System.out.println("===================");
			System.out.print("번호 입력 ===> "); n = scan.nextInt();
			
			switch(n) {
			case 1:
				System.out.println("<< 연락처 정보 입력 >>");
				System.out.print("- 이름 : "); name = scan.next();
				System.out.print("- 이메일 : "); email = scan.next();
				gm.showData();
				System.out.print("- 그룹 ID: "); gId = scan.nextInt();
				group = gm.findTitleById(gId);
				c.addContact(name, email, group);
				break;
			case 2:
				c.addContact2();
				break;
			case 3:
				System.out.print("- 찾고싶은 이름 입력 : ");
				fName = scan.next();
				c.findContactByName(fName);
				break;
			case 4:
				c.showData();
				break;
			case 5:
				System.out.print("- 추가할 그룹 이름 : ");
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
