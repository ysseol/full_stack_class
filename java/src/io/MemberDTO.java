package io;

import java.io.Serializable;

public class MemberDTO implements Serializable {
	private String name;
	private int age;
	private transient MemberInfoDTO memberInfo;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public MemberInfoDTO getMemberInfo() {
		return memberInfo;
	}
	
	public void setMemberInfo(MemberInfoDTO memberInfo) {
		this.memberInfo = memberInfo;
	}

	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", age=" + age + ", memberInfo=" + memberInfo + "]";
	}

	public MemberDTO(String name, int age, String jumin, String pwd) {
		this.name = name;
		this.age = age;
		this.memberInfo = new MemberInfoDTO(jumin, pwd);
	}
	
}
