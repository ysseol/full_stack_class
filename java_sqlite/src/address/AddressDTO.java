package address;

public class AddressDTO {
	
	private String email;
	private String name;
	private String address;
	private String hp;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
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
	
	public String getHp() {
		return hp;
	}
	
	public void setHp(String hp) {
		this.hp = hp;
	}
	
	@Override
	public String toString() {
		return "AddressDTO [email=" + email + ", name=" + name + ", address=" + address + ", hp=" + hp + "]";
	}
	
	public AddressDTO() {
	}

	public AddressDTO(String email, String name, String address, String hp) {
		this.email = email;
		this.name = name;
		this.address = address;
		this.hp = hp;
	}
	
}
