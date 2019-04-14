package com.Bean;

import java.util.ArrayList;

public class CustomerBean {
	private int custId;
	private static int CustomerId=100;
	private String First_Name;
	private String Middle_Name;
	private String Last_Name;
	private String Date_of_Birth;
	private String Gender;
	private String Permanent_Address;
	private String Present_Address;
	private String Occupation;
	private float Annual_Salary;
	private String Married;
	private int Children;
	private String Email;
	private String Phone;
	private String PAN_card;
	ArrayList<Nominee> alist=new ArrayList<Nominee>();
	


	public String getFirst_Name() {
		return First_Name;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getMiddle_Name() {
		return Middle_Name;
	}
	public void setMiddle_Name(String middle_Name) {
		Middle_Name = middle_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getDate_of_Birth() {
		return Date_of_Birth;
	}
	public void setDate_of_Birth(String date_of_Birth) {
		Date_of_Birth = date_of_Birth;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getPermanent_Address() {
		return Permanent_Address;
	}
	public void setPermanent_Address(String permanent_Address) {
		Permanent_Address = permanent_Address;
	}
	public String getPresent_Address() {
		return Present_Address;
	}
	public void setPresent_Address(String present_Address) {
		Present_Address = present_Address;
	}
	public String getOccupation() {
		return Occupation;
	}
	public void setOccupation(String occupation) {
		Occupation = occupation;
	}
	public float getAnnual_Salary() {
		return Annual_Salary;
	}
	public void setAnnual_Salary(float annual_Salary) {
		Annual_Salary = annual_Salary;
	}
	public String getMarried() {
		return Married;
	}
	public void setMarried(String married) {
		Married = married;
	}
	public int getChildren() {
		return Children;
	}
	public void setChildren(int children) {
		Children = children;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getPAN_card() {
		return PAN_card;
	}
	public void setPAN_card(String pAN_card) {
		PAN_card = pAN_card;
	}
	public CustomerBean(String first_Name, String middle_Name, String last_Name,
			String date_of_Birth, String gender, String permanent_Address, String present_Address,
			String occupation, float annual_Salary, String married, int children, String email, String phone,
			String pAN_card) {
		super();
		this.custId =CustomerId++;
		this.First_Name = first_Name;
		this.Middle_Name = middle_Name;
		this.Last_Name = last_Name;
		this.Date_of_Birth = date_of_Birth;
		this.Gender = gender;
		this.Permanent_Address = permanent_Address;
		this.Present_Address = present_Address;
		this.Occupation = occupation;
		this.Annual_Salary = annual_Salary;
		this.Married = married;
		this.Children = children;
		this.Email = email;
		this.Phone = phone;
		this.PAN_card = pAN_card;
		this.alist=alist;
	
	}
	public CustomerBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
