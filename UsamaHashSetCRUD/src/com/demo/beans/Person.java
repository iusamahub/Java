package com.demo.beans;

public class Person implements Comparable<Person>{
	protected int pid;
	private String pname;
	private String mobile;
	private String email;
	public Person() {
		super();
	}
	public Person(int pid, String pname, String mobile, String email) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.mobile = mobile;
		this.email = email;
	}
	public Person(int pid) {
		this.pid = pid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", mobile=" + mobile + ", email=" + email + "]";
	}
	
	public boolean equals(Object o) {
		return this.getPid()==((Person)o).getPid();
	}
	
	@Override
	public int hashCode() {
		return pid;
	}
	
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.pname.compareTo(o.pname);
	}
}
