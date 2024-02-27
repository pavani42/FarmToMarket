//package com.dnapass.training.test;
//
//import static org.junit.Assert.assertEquals;
//
//import com.dnapass.training.entity.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//@RunWith(SpringRunner.class)
//public class TestFarmToMarketEntity {
//
//	private User user;
//	private User user1;
//	private Item item;
//	private Equipment equipment;
//	private EquipmentUser equipmentUser;
//
//	private static final String MOBILENUMBER = "9876543210";
//	private static final String STATE = "Tamilnadu";
//	private static final String CITY = "Chennai";
//	private static final String PINCODE = "600116";
//	private static final Roles ROLE = Roles.Farmer;
//	private static final Roles EROLE = Roles.Equipment_Owner;
//	private static final String USERNAME = "Ramesh";
//	private static final String PASSWORD = "abcd";
//
//	private static final String ITEMNAME = "Potato";
//	private static final String ITEMDESCRIPTION = "Vegetable";
//	private static final Integer QUANTITY = 20;
//
//	private static final String NAME = "Drone";
//	private static final Integer COUNT = 20;
//	private static final Integer RENTPERDAY = 20000;
//	private static final String ESTATE = "Tamilnadu";
//	private static final String ECITY = "Chennai";
//	private static final String VILLAGE = "Tiruvallur";
//	private static final String EPINCODE = "600113";
//	private static final String CONTACTPERSON = "Suresh";
//	private static final String EMOBILENUMBER = "9826535155";
//	private static final String STATUS = "Available";
//
//	@Before
//	public void setUp() {
//		user = new User(MOBILENUMBER,STATE,CITY,PINCODE,ROLE,USERNAME,PASSWORD);
//		user1 = new User(MOBILENUMBER,STATE,CITY,PINCODE,EROLE,USERNAME,PASSWORD);
//
//		item = new Item(ITEMNAME,ITEMDESCRIPTION,QUANTITY,user);
//
//		equipment = new Equipment(NAME,COUNT,RENTPERDAY,ESTATE,ECITY,VILLAGE,EPINCODE,CONTACTPERSON,EMOBILENUMBER,user1);
//
//		equipmentUser=new EquipmentUser(user,equipment,QUANTITY);
//	}
//
//	@Test
//	public void testUser() {
//		assertEquals(MOBILENUMBER, user.getMobileNumber());
//		assertEquals(STATE, user.getState());
//		assertEquals(CITY, user.getCity());
//		assertEquals(ROLE, user.getRole());
//		assertEquals(USERNAME, user.getUserName());
//	}
//
//	@Test
//	public void testItem() {
//		assertEquals(ITEMNAME, item.getItemName());
//		assertEquals(USERNAME, item.getUser().getUserName());
//	}
//
//	@Test
//	public void testEquipment() {
//        assertEquals(NAME,equipment.getEquipmentName());
//        assertEquals(ROLE,equipment.getUser().getRole());
//	}
//
//	@Test
//	public void testEquipmentUser() {
//		assertEquals(user.getUserName(),equipmentUser.getUser().getUserName());
//		assertEquals(equipment.getEquipmentName(),equipmentUser.getEquipment().getEquipmentName());
//	}
//}
