package collect;

import java.util.ArrayList;
import java.util.List;

public class Address {
	private String name;
	private String address;
	private String phone;
	private String email;
	
	public Address(String name, String address, String phone, String email) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return name + "\t" + address + "\t" + phone + "\t" + email;
	}
	
	public static void main(String[] args) {
		List<Address> list = new ArrayList<>();
		Address[] addresses = { 
				new Address("kim", "서울 구로구", "010-222-3333", "kim@nate.com"),
				new Address("park", "인천 계양구", "010-333-3333", "park@nate.com"),
				new Address("lee", "경기 의정부", "010-555-3333", "lee@nate.com"),
				new Address("choi", "경기 성남", "010-567-3333", "choi@nate.com"),
				new Address("hong", "서울 마포구", "010-777-3333", "hong@nate.com")
		};
		for (int i = 0; i < addresses.length; i++) {
			list.add(addresses[i]);
		}
		System.out.println("이름\t주소\t전화\t\t이메일");
		for (Address address : list) {
			System.out.println(address.getName() + "\t" + address.getAddress() 
						+ "\t" + address.getPhone() + "\t" + address.getEmail());
		}
	}
}
