package member;

public class Member {
	private String name;
	private String tel;
	private String email;

	public Member(String name, String tel, String email) {
		this.name = name;
		this.tel = tel;
		this.email = email;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public void disp() {
		System.out.println("이름 :" + name + ", 전화번호 : " + tel + ", 이메일주소 : " + email);
	}

	
}
