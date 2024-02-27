//package com.dnapass.training.test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertFalse;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import com.dnapass.training.entity.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.dnapass.training.repository.EquipmentRepository;
//import com.dnapass.training.repository.ItemRepository;
//import com.dnapass.training.repository.UserRepository;
//import com.dnapass.training.service.EquipmentService;
//import com.dnapass.training.service.ItemService;
//import com.dnapass.training.service.UserService;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TestFarmToMarketService {
//
//	@Autowired
//	EquipmentService equipmentService;
//
//	@Autowired
//	ItemService itemService;
//
//	@Autowired
//	UserService userService;
//
//	@MockBean
//	EquipmentRepository equipmentRepository;
//
//	@MockBean
//	UserRepository userRepository;
//
//	@MockBean
//	ItemRepository itemRepository;
//
//	@Test
//	public void testSaveUser(){
//		User user=new User("9847572727","Tamilnadu","Chennai","600116",Roles.Farmer,"Senthil","abcd");
//	    Mockito.when(userRepository.save(user)).thenReturn(user);
//	    assertThat(userService.saveUser(user)).isEqualTo(user);
//	}
//
//	@Test
//	public void testFindUser() {
//		User user=new User(1,"Senthil","9847572727","abcd", Roles.Farmer,"Chennai","600116","Tamilnadu");
//		Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));
//		userService.findUser(user.getUserid());
//		assertThat(userService.findUser(user.getUserid())).isEqualTo(user);
//	}
//
//	@Test
//	public void testGetFarmerDetails() {
//		User user=new User(1,"Senthil","9847572727","abcd", Roles.Farmer,"Chennai","600116","Tamilnadu");
//		Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));
//		userService.findUser(user.getUserid());
//		assertThat(userService.findUser(user.getUserid())).isEqualTo(user);
//	}
//
//	@Test
//	public void testAddNewItem() {
//		User user=new User(1,"Senthil","9847572727","abcd", Roles.Farmer,"Chennai","600116","Tamilnadu");
////		Item item=new Item(10,"Cabbage","vegetable",20,user);
//		Item item = new Item(10,"Cabbage",20,user,"Vegetable");
//		Mockito.when(itemRepository.save(item)).thenReturn(item);
//	    assertThat(itemService.addNewItem(item)).isEqualTo(item);
//	}
//
//	@Test
//	public void testGetAllItems(){
//		List<ItemDetails> itemList=null;
//		Mockito.when(itemRepository.findAllItems()).thenReturn(itemList);
//		assertThat(itemService.getAllItems()).isEqualTo(itemList);
//	}
//
//	@Test
//	public void testDeleteItemDetails(){
//		User user=new User(1,"Senthil","9847572727","abcd", Roles.Farmer,"Chennai","600116","Tamilnadu");
//		Item item=new Item("Cabbage", "Vegetable", 10, user);
////		new Item(10,"Cabbage",20,user,"Vegetable");
//		Mockito.when(itemRepository.findById(1)).thenReturn(Optional.of(item));
//	    itemService.deleteItemDetails(item.getItemId());
//	    assertFalse(itemRepository.existsById(item.getItemId()));
//	}
//
//	@Test
//	public void testGetItemById() {
//		User user=new User(1,"Senthil","9847572727","abcd", Roles.Farmer,"Chennai","600116","Tamilnadu");
//		Item item=new Item(10,"Cabbage",20,user,"vegetable");
//		Mockito.when(itemRepository.findById(10)).thenReturn(Optional.of(item));
//		itemService.getItemById(item.getItemId());
//		assertThat(itemService.getItemById(item.getItemId())).isEqualTo(item);
//	}
//
//	@Test
//	public void testSearchItem() {
//		User user=new User(1,"Senthil","9847572727","abcd", Roles.Farmer,"Chennai","600116","Tamilnadu");
//		ItemDetails item1=new ItemDetails(10,"Cabbage",20,user.getUserName(),user.getMobileNumber(),user.getUserid());
//		ItemDetails item2=new ItemDetails(11,"Potato",25,user.getUserName(),user.getMobileNumber(),user.getUserid());
//		List<ItemDetails> itemList=new ArrayList<>();
//		itemList.add(item1);
//		itemList.add(item2);
//		Mockito.when(itemRepository.getItemDetailsBasedCity("Chennai")).thenReturn(itemList);
//		itemService.searchItem("Chennai");
//		assertThat(itemService.searchItem("Chennai")).isEqualTo(itemList);
//	}
//
//	@Test
//	public void testAddEquipment() {
//		User user=new User(1,"Senthil","9847572727","abcd", Roles.Farmer,"Chennai","600116","Tamilnadu");
//		Equipment equipment=new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user);
//		Mockito.when(equipmentRepository.save(equipment)).thenReturn(equipment);
//	    assertThat(equipmentService.addEquipment(equipment)).isEqualTo(equipment);
//	}
//
//	@Test
//	public void testSearchEquipment() {
//		User user=new User(1,"Senthil","9847572727","abcd", Roles.Farmer,"Chennai","600116","Tamilnadu");
//		Equipment equipment1 = new Equipment(11,"Drone","Rajesh", "8736514243",30000,20,"Tamilnadu","Chennai","Poru","600015",user);
//		Equipment equipment2=new Equipment(12,"Tractor","Ramesh", "8344272711",35000,15,"Tamilnadu","Chennai","Tiru","300015",user);
////		Equipment equipment2=new Equipment(12,"Tractor",15, 35000.0,"Tamilnadu","Chennai","Tiru","300015","Ramesh","8344272711","Available",user);
//		List<Equipment> list=new ArrayList<>();
//		list.add(equipment1);
//		list.add(equipment2);
//		Mockito.when(equipmentRepository.findByCity("Chennai")).thenReturn(list);
//		assertThat(equipmentService.searchEquipment("Chennai")).isEqualTo(list);
//	}
//
//	@Test
//	public void testGetAllEquipment(){
//		List<Equipment> equipmentList=new ArrayList<>();
//		Mockito.when(equipmentRepository.findEquipmentByCount()).thenReturn(equipmentList);
//		assertThat(equipmentService.getAllEquipment()).isEqualTo(equipmentList);
//	}
//
//
//
//	@Test
//	public void testDeleteEquipmentDetail(){
//		User user=new User(1,"Senthil","9847572727","abcd", Roles.Farmer,"Chennai","600116","Tamilnadu");
//		Equipment equipment=new Equipment(11,"Drone","Rajesh", "8736514243",30000,20,"Tamilnadu","Chennai","Poru","600015",user);
//		Mockito.when(equipmentRepository.findById(1)).thenReturn(Optional.of(equipment));
//	    equipmentService.deleteEquipmentDetail(equipment.getEquipmentId());
//	    assertFalse(equipmentRepository.existsById(equipment.getEquipmentId()));
//	}
//
//	@Test
//	public void testGetEquipmentById() {
////		User user=new User(2,"9873626111","Mumbai","Maharastra","600115","equipmentowner","Suresh","abcd");
//		User user=new User(2,"Suresh","9873626111","abcd", Roles.Equipment_Owner,"Mumbai","600116","Maharastra");
//		Equipment equipment=new Equipment(11,"Drone","Rajesh", "8736514243",30000,20,"Tamilnadu","Chennai","Poru","600015",user);
//		Mockito.when(equipmentRepository.findById(11)).thenReturn(Optional.of(equipment));
//		equipmentService.getEquipmentById(equipment.getEquipmentId());
//		assertThat(equipmentService.getEquipmentById(equipment.getEquipmentId())).isEqualTo(equipment);
//	}
//
//
//}
