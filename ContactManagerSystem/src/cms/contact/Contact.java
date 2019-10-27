package cms.contact;

public abstract class Contact {
	public String name;
	public String email;
	
	Contact(String name, String email){
		this.name = name;
		this.email = email;
	}
	
	public abstract void ShowData();

}

class PeopleContact extends Contact{
	public String group;
	
	public PeopleContact(String name, String email, String group) {
		super(name, email);
		this.group = group;
	}
	
	@Override
	public void ShowData() {
		System.out.println("이름 : "+name+"이메일 : "+email+"그룹 : "+group);
	}
}


class CompanyContact extends Contact{
	public String ceo;
	public String city;
	
	public CompanyContact(String name, String email, String ceo, String city) {
		super(name, email);
		this.ceo = ceo;
		this.city = city;
	}
	
	@Override
	public void ShowData() {
		System.out.println("이름 : "+name+"이메일 : "+email+"대표 : "+ceo+"도시:" +city);
	}
}
