package com.dnapass.training.entity;

import java.util.*;
import jakarta.persistence.*;

import javax.management.relation.Role;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String username;

	private String mobileNumber;
	private String password;
	private String role;

	private String city;
	private String pinCode;
	private String state;

	public User()
	{

	}
	public User(int userid, String userName, String mobileNumber, String password, String role, String city, String pinCode, String state) {
		this.id = userid;
		this.username = userName;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.role = role;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
	}

	@OneToMany
	private List<Item> itemList;

	public User(String mobilenumber, String state, String city, String pincode, String role, String username, String password) {
		this.mobileNumber = mobilenumber;
		this.state = state;
		this.city = city;
		this.pinCode = pincode;
		this.role = "Farmer";
		this.username= username;
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int userid) {
		this.id = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
