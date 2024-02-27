//package com.dnapass.training.test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import com.dnapass.training.entity.*;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.dnapass.training.repository.EquipmentRepository;
//import com.dnapass.training.repository.EquipmentUserRepository;
//import com.dnapass.training.repository.ItemRepository;
//import com.dnapass.training.repository.UserRepository;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
////@DataJpaTest
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class TestFarmToMarketRepository {
//
//	private User user,user1,user2;
//	private Item item;
//
//	@Autowired
//	UserRepository userRepository;
//
//	@Autowired
//	ItemRepository itemRepository;
//
//	@Autowired
//	EquipmentRepository equipmentRepository;
//
//	@Autowired
//	EquipmentUserRepository equipmentUserRepository;
//
//	@Before
//	public void setUp() {
//		user = new User("9847646122","Tamilnadu","Chennai","600116", Roles.Farmer,"Rajesh","abcd");
//		user1 = new User("8847646122","Maharastra","Mumbai","220116",Roles.Equipment_Owner,"Ramesh","abcd");
//		user2 = new User("734566122","Tamilnadu","Coimbatore","640116",Roles.Trader,"Rakesh","abcd");
//	     item=new Item("Potato","Vegetable",25,user);
//	}
//
//	@Test
//	public void testAddUser() {
//		User savedInDb = userRepository.save(user);
//		Optional<User> data = userRepository.findById(savedInDb.getUserid());
//        User getFromDb = (User)data.get();
//        assertEquals(savedInDb.getUserid(),getFromDb.getUserid());
//	}
//
//	@Test
//	public void testFindUser() {
//		User savedInDb = userRepository.save(user);
//		Optional<User> data = userRepository.findById(savedInDb.getUserid());
//        User getFromDb = (User)data.get();
//        assertThat(getFromDb.getUserid()).isEqualTo(savedInDb.getUserid());
//	}
//
//	@Test
//	public void testAddItem() {
//		User savedInDb = userRepository.save(user);
//		Item savedItemDb=itemRepository.save(item);
//		assertThat(savedItemDb.getItemName()).isEqualTo("Potato");
//	}
//
//	@Test
//	public void testGetAllItems() {
//		List<ItemDetails> itemList=itemRepository.findAllItems();
//		assertThat(itemList.size()).isEqualTo(1);
//	}
//
//	@Test
//	public void testGetItemById() {
//		User savedInDb = userRepository.save(user);
//		Item savedItemDb=itemRepository.save(item);
//		Item item=itemRepository.findById(savedItemDb.getItemId()).get();
//		assertThat(item.getItemId()).isEqualTo(item.getItemId());
//	}
//
//	@Test
//	public void testGetAllItemsById() {
//		User savedInDb = userRepository.save(user);
//		Item savedItemDb=itemRepository.save(item);
//		List<Item> list=itemRepository.findAllItem(savedInDb.getUserid());
//		assertThat(list.size()).isEqualTo(1);
//	}
//
//    @Test
//    public void testItemCitySearch() {
//    	List<ItemDetails> list=itemRepository.getItemDetailsBasedCity("Chennai");
//        List<ItemDetails> iList = new ArrayList<>();
//		System.out.println(list.size());
//		for (ItemDetails item : list) {
//			iList.add(item);
//		}
//		assertThat(iList.size()).isEqualTo(list.size());
//    }
//
//	@Test
//	public void testItemDeleteItemDetails() {
//		User savedInDb = userRepository.save(user);
//		Item savedItemDb=itemRepository.save(item);
//		List<Item> itemList1=itemRepository.findAll();
//		Item item=itemRepository.findById(savedItemDb.getItemId()).get();
//		System.out.println(item.getItemId() + "" + item.getUser().getUserid());
//		itemRepository.deleteById(item.getItemId());
//		List<Item> itemList=itemRepository.findAll();
//		assertThat(itemList.size()).isEqualTo(itemList1.size()-1);
//	}
//
//	@Test
//	public void testAddEquipment() {
//		User savedInDb = userRepository.save(user1);
//		Equipment e = new Equipment(100,"Drone","John","8736514243",3000,20,"Kerela","Trivandrum","Cochin","300021",user1);
//		Equipment equipment=equipmentRepository.save(e);
//		assertEquals(e.getEquipmentName(),equipment.getEquipmentName());
//		assertEquals(e.getUser().getUserName(),equipment.getUser().getUserName());
//	}
//
//	@Test
//	public void testSearchEquipment() {
//		List<Equipment> list=equipmentRepository.findByCity("Cochin");
//		assertEquals("Drone",list.get(0).getEquipmentName());
//	}
//
//	@Test
//	public void testGetAllEquipment() {
//		List<Equipment> list=equipmentRepository.findEquipmentByCount();
//		List<Equipment> elist=new ArrayList<>();
//		for(Equipment e:list) {
//			elist.add(e);
//		}
//		assertEquals(elist.size(),list.size());
//	}
//
//	@Test
//	public void testGetAllEquipmentById() {
//		User savedInDb = userRepository.save(user1);
////		new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1));
////		list.add(new Equipment(101,"Tractor","Jack","7536514243",25000,25,"Kerala","Cochin","Trivandrum","200021",user1));
//		Equipment e = new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1);
//		Equipment e1 = new Equipment(101,"Tractor","Jack","7536514243",25000,25,"Kerala","Cochin","Trivandrum","200021",user1);
//		List<Equipment> elist=new ArrayList<>();
//		elist.add(e);
//		elist.add(e1);
//		equipmentRepository.saveAll(elist);
//		System.out.println(savedInDb.getUserid());
//		List<Equipment> list=equipmentRepository.findAllEquipment(savedInDb.getUserid());
//		assertEquals(list.size(),2);
//	}
//
//	@Test
//	public void testAddEquipmentUser() {
//		User savedInDb = userRepository.save(user1);
//		Equipment e = new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1);
//		equipmentRepository.save(e);
//		EquipmentUser euser=new EquipmentUser(savedInDb,e,20);
//		equipmentUserRepository.save(euser);
//		assertEquals(euser.getEquipment().getEquipmentName(),"Drone");
//	}
//
//	@Test
//	public void testGetHiredEquipment() {
//		User savedInDb = userRepository.save(user1);
//		Equipment e = new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1);
//		equipmentRepository.save(e);
//		EquipmentUser euser=new EquipmentUser(savedInDb,e,20);
//		equipmentUserRepository.save(euser);
////		List<EquipmentDetails> elist=equipmentRepository.findHiredEquipment(savedInDb.getId());
////		assertEquals(elist.get(0).getQuantityCount(),euser.getQuantity());
//	}
//
//	@Test
//	public void testDeleteEquipmentUser() {
//		User savedInDb = userRepository.save(user1);
//		Equipment e = new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1);
//		equipmentRepository.save(e);
//		EquipmentUser euser=new EquipmentUser(savedInDb,e,20);
//		equipmentUserRepository.save(euser);
//		equipmentUserRepository.deleteById(euser.getId());
//		Optional eusr=equipmentUserRepository.findById(euser.getId());
//		assertTrue(eusr.isEmpty());
//	}
//}
