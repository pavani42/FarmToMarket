package com.dnapass.training.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table
public class EquipmentUser {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Integer id;

//   @GeneratedValue(strategy = GenerationType.UUID)
//   private Integer bookingId;

//	public Integer getBookingId() {
//		return bookingId;
//	}
//
//	public void setBookingId(Integer bookingId) {
//		this.bookingId = bookingId;
//	}
   @ManyToOne
   @JoinColumn(name = "userid")
   private User user;
   
   @ManyToOne
   @JoinColumn(name = "equipmentId")
   private Equipment equipment;
   
   private Integer quantity;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Equipment getEquipment() {
	return equipment;
}

public void setEquipment(Equipment equipment) {
	this.equipment = equipment;
}

public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

public EquipmentUser(Integer id, User user, Equipment equipment, Integer quantity) {
	super();
	this.id = id;
	this.user = user;
	this.equipment = equipment;
	this.quantity = quantity;
}

public EquipmentUser() {
	super();
	// TODO Auto-generated constructor stub
}

public EquipmentUser(User user, Equipment equipment, Integer quantity) {
	super();
	this.user = user;
	this.equipment = equipment;
	this.quantity = quantity;
}

}
