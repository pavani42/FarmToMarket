package com.dnapass.training.entity;

import jakarta.persistence.*;

@Entity
@Table
//(name="equipment")
public class Equipment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String contactPerson;
	private String mobileNumber;
	private Double rentPerDay;
	private Integer count;
	private String state;
	private String city;

	private String status;

	public Equipment(int equipmentId, String sprayer, int i, double v, String kerela, String cochin, String trivandrum, String number, String jim, String number1, User user1) {
		this.id = equipmentId;
		this.name = sprayer;
		this.count = i;
		this.rentPerDay = v;
		this.state = kerela;
		this.city = cochin;
		this.user = user1;
		this.contactPerson = jim;
		this.mobileNumber = number1;
		this.pinCode = number;
		this.village = trivandrum;
	}

	public Equipment(int equipmentId, String sprayer, int i, double v, String kerela, String cochin, String trivandrum, String number, String jim, String number1, String status, User user1) {
		this.id = equipmentId;
		this.name = sprayer;
		this.count = i;
		this.rentPerDay = v;
		this.state = kerela;
		this.city = cochin;
		this.user = user1;
		this.contactPerson = jim;
		this.mobileNumber = number1;
		this.pinCode = number;
		this.village = trivandrum;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public Equipment()
	{

	}
	public Equipment(String name, Integer count, Double rentperday, String estate, String ecity, String village, String epincode, String contactperson, String emobilenumber, User user1)
	{
		this.name = name;
		this.count = count;
		this.rentPerDay = rentperday;
		this.state = estate;
		this.city = ecity;
		this.village = village;
		this.contactPerson = contactperson;
		this.mobileNumber = emobilenumber;
		this.user = user1;
	}

	public Equipment(Integer equipmentId, String equipmentName, String contactPerson, String mobileNumber, Double rentPerday, Integer quantityCount, String state, String city, String village, String pinCode, User user) {
		this.id = equipmentId;
		this.name = equipmentName;
		this.contactPerson = contactPerson;
		this.mobileNumber = mobileNumber;
		this.rentPerDay = rentPerday;
		this.count = quantityCount;
		this.state = state;
		this.city = city;
		this.village = village;
		this.pinCode = pinCode;
		this.user = user;
	}

	public void setEquipmentId(Integer equipmentId) {
		this.id = equipmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String equipmentName) {
		this.name = equipmentName;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Double getRentPerDay() {
		return rentPerDay;
	}

	public void setRentPerDay(Double rentPerday) {
		this.rentPerDay = rentPerday;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer quantityCount) {
		this.count = quantityCount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private String village;
	private String pinCode;
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
   
}
