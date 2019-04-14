package com.Bean;

public class Nominee {
	private int Nomineeid ;
	private String Nomineename;
	private String Relationship;
	private CustomerBean Customer;
	public Nominee(int nomineeid, String nomineename, String relationship) {
		super();
		Nomineeid = nomineeid;
		Nomineename = nomineename;
		Relationship = relationship;
	}
	public Nominee(){
		super();
	}
	public int getNomineeid() {
		return Nomineeid;
	}
	public void setNomineeid(int nomineeid) {
		Nomineeid = nomineeid;
	}
	public String getNomineename() {
		return Nomineename;
	}
	public void setNomineename(String nomineename) {
		Nomineename = nomineename;
	}
	public String getRelationship() {
		return Relationship;
	}
	public void setRelationship(String relationship) {
		Relationship = relationship;
	}
	public CustomerBean getCustomer() {
		return Customer;
	}
	public void setCustomer(CustomerBean customer) {
		Customer = customer;
	}
	
	

}
