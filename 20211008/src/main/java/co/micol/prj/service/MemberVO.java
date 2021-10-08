package co.micol.prj.service;

public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String tel;
	private String addresss;
	private String author;

	public MemberVO() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddresss() {
		return addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String toString() {
		System.out.print(id + " ");
		System.out.print(name + " ");
		System.out.print(password + " ");
		System.out.print(tel + " ");
		System.out.print(addresss + " ");
		System.out.println(author + " ");
		return null;
	}

}
