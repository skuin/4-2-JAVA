package cms.contact;

import java.util.Scanner;
import cms.show.Showable;

public class ContactManager implements Showable {
	PeopleContact[] carr = new PeopleContact[100];
	CompanyContact[] ccarr = new CompanyContact[100];
	int index = 0;
	int indexCom = 0;
	Scanner scan = new Scanner(System.in);
	
	public ContactManager() {}
	public ContactManager(int n) {}
	
	public void addContact(String name, String email, String group) {
		
		carr[index++] = new PeopleContact(name, email, group);
	}
	
	public void addContact2() {
		String name, email, ceo, city;
		
		System.out.println("<< ����ó ���� �Է� >>");
		System.out.print("- �̸� : "); name = scan.next();
		System.out.print("- �̸��� : "); email = scan.next();
		System.out.print("- ��ǥ : "); ceo = scan.next();
		System.out.print("- ���� : "); city = scan.next();
		ccarr[indexCom++] = new CompanyContact(name, email, ceo, city);
	}
	
	public void findContactByName(String fName) {
		boolean isFound = false;
		
		for(int i = 0 ; i< index ; i++) {
			if(carr[i].name.equals(fName)) {
				carr[i].ShowData();
				isFound = true;
			}
			if(ccarr[i].name.equals(fName)) {
				ccarr[i].ShowData();
				isFound = true;
			}
		}
		
		if (isFound == false) {
			System.out.println("�׷��̸��� �����ϴ�. ");
		}
	}
	
	@Override
	public void showData() {
		for(int i = 0 ;i<index; i++) {
			carr[i].ShowData();
		}
		for(int i = 0 ;i<indexCom; i++) {
			ccarr[i].ShowData();
		}
	}
}
