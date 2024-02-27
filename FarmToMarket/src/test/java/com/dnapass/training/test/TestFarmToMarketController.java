//package com.dnapass.training.test;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.BDDMockito.willDoNothing;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.dnapass.training.entity.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import com.dnapass.training.controller.FarmMarketController;
//import com.dnapass.training.service.EquipmentService;
//import com.dnapass.training.service.ItemService;
//import com.dnapass.training.service.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = FarmMarketController.class)
//public class TestFarmToMarketController {
//
//	private User user, user1, user2;
//
//	@Autowired
//	private MockMvc mockMvc; // test the controller
//
//	@MockBean
//	private UserService userService;
//
//	@MockBean
//	EquipmentService equipmentService;
//
//	@MockBean
//	ItemService itemService;
//
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	@Before
//	public void setUp() {
//		user=new User(1,"Rajesh","9847646122","abcd", Roles.Farmer,"Chennai","521123","Tamilnadua");
//		user1=new User(2,"Ramesh","8847646122","abcd",Roles.Equipment_Owner,"Mumbai","521125","Maharastra");
//		user2=new User(3,"Rakesh","734566122","abcd",Roles.Farmer,"Coimbatore","521125","Tamilnadu");
//	}
//
//	@Test
//	public void testLogin() throws Exception {
//		Login login1=new Login(1,"abcd","Farmer");
//		given(userService.findUser(login1.getUserid())).willAnswer((invocation) -> invocation.getArgument(0));
//		ResultActions response = mockMvc.perform(post("/farmmarket/login")
//				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(login1)));
//		System.out.println(response);
//		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.role", is(login1.getRole().toString())));
//	}
//
//	@Test
//	public void testCreateUser() throws Exception {
//		given(userService.saveUser(any(User.class))).willAnswer((invocation) -> invocation.getArgument(0));
//
//		ResultActions response = mockMvc.perform(post("/farmmarket/newuser").contentType(MediaType.APPLICATION_JSON)
//				.content(objectMapper.writeValueAsString(user)));
//
//		response.andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("$.mobileNumber", is(user.getMobileNumber())))
//				.andExpect(jsonPath("$.state", is(user.getState()))).andExpect(jsonPath("$.city", is(user.getCity())))
//				.andExpect(jsonPath("$.role", is(user.getRole().toString())))
//				.andExpect(jsonPath("$.userName", is(user.getUserName())));
//	}
//
//	@Test
//	public void testFarmerSearchEquipment() throws Exception {
//		List<Equipment> list = new ArrayList<>();
//		list.add(new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1));
//		list.add(new Equipment(101,"Tractor","Jack","7536514243",25000,25,"Kerala","Cochin","Trivandrum","200021",user1));
//		list.add(new Equipment(102,"Sprayer","Jim","6736514243",27000,30,"Kerala","Cochin","Trivandrum","600021",user1));
//		//		list.add(new Equipment(102,"Sprayer",30,27000.0,"Kerela","Cochin","Trivandrum","600021","Jim","6736514243",user1));
//		given(equipmentService.searchEquipment("Cochin")).willReturn(list);
//
//		ResultActions response = mockMvc.perform(get("/farmmarket/search").param("city", "Cochin"));
//
//		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(list.size())))
//				.andExpect(jsonPath("$[0].equipmentName").value("Drone")).andExpect(jsonPath("$[0].quantityCount").value(20))
//				.andExpect(jsonPath("$[1].equipmentName").value("Tractor")).andExpect(jsonPath("$[1].quantityCount").value(25))
//				.andExpect(jsonPath("$[2].equipmentName").value("Sprayer")).andExpect(jsonPath("$[2].quantityCount").value(30));
//	}
//
//	@Test
//	public void testGetAllEquipment() throws Exception {
//		List<Equipment> listOfEquipment = new ArrayList<>();
//		listOfEquipment.add(new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1));
//		listOfEquipment.add(new Equipment(101,"Tractor","Jack","7536514243",25000,25,"Kerala","Cochin","Trivandrum","200021",user1));
//		listOfEquipment.add(new Equipment(102,"Sprayer","Jim","6736514243",27000,30,"Kerala","Cochin","Trivandrum","600021",user1));
//		given(equipmentService.getAllEquipment()).willReturn(listOfEquipment);
//
//		ResultActions response = mockMvc.perform(get("/farmmarket/getAllEquipment"));
//
//		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(listOfEquipment.size())));
//	}
//
//	@Test
//	public void testgetAllEquipmentById() throws Exception {
//		Equipment e = new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1);
//		Equipment e1 = new Equipment(101,"Tractor","Jack","7536514243",25000,25,"Kerala","Cochin","Trivandrum","200021",user1);
//		List<Equipment> list=new ArrayList<>();
//		list.add(e);
//		list.add(e1);
//		given(equipmentService.getAllEquipmentById(user1.getUserid())).willReturn(list);
//
//		ResultActions response = mockMvc.perform(get("/farmmarket/getAllEquipmentById/{id}", user1.getUserid()));
//
//		response.andExpect(status().isOk()).andDo(print())
//		        .andExpect(jsonPath("$[0].equipmentName").value("Drone"))
//				.andExpect(jsonPath("$.size()", is(list.size())));
//	}
//
//	@Test
//	public void testGetAllItemById() throws Exception {
//		Item item1 = new Item(1000,"Potato",50,user,"Vegetable");
//		Item item2 = new Item(1001,"Tomato",30,user,"Cherry Tomato");
//
//		List<Item> itemList=new ArrayList<>();
//		itemList.add(item1);
//		itemList.add(item2);
//        given(itemService.getAllItemById(user.getUserid())).willReturn(itemList);
//
//		ResultActions response = mockMvc.perform(get("/farmmarket/getAllItemById/{id}", user.getUserid()));
//
//		response.andExpect(status().isOk()).andDo(print())
//		          .andExpect(jsonPath("$[0].itemName").value("Potato"))
//		          .andExpect(jsonPath("$.size()", is(itemList.size())));
//	}
//
//	@Test
//	public void testBookEquipment() throws Exception {
//		int ecount=2;
//		Equipment e = new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1);
//		given(equipmentService.getEquipmentById(e.getEquipmentId())).willReturn(e);
//		e.setQuantityCount(e.getQuantityCount() - ecount);
//		//e.setStatus("Booked");
//		given(equipmentService.addEquipment(any(Equipment.class)))
//				.willAnswer((invocation) -> invocation.getArgument(0));
//		ResultActions response = mockMvc.perform(put("/farmmarket/book/{equipId}/{userid}/{quantitycount}", e.getEquipmentId(),e.getUser().getUserid(),ecount)
//				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(e)));
//
//		response.andExpect(status().isOk()).andDo(print())
//		        .andExpect(jsonPath("$.equipmentName", is(e.getEquipmentName())))
//				.andExpect(jsonPath("$.quantityCount", is(e.getQuantityCount())));
//	}
//
//	@Test
//	public void testAddNewItem() throws Exception {
//		System.out.println(user);
//		Item item = new Item(1000,"Potato",50,user,"Vegetable");
//		given(itemService.addNewItem(any(Item.class))).willAnswer((invocation) -> invocation.getArgument(0));
//
//		ResultActions response = mockMvc.perform(post("/farmmarket/addNewItem/{id}",user.getUserid())
//				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(item)));
////        System.out.println("$.itemName");
//		response.andDo(print()).andExpect(status().isOk())
//				.andExpect(jsonPath("$.itemName", is(item.getItemName())))
//				.andExpect(jsonPath("$.itemQuantity", is(item.getItemQuantity())));
//	}
//
//	@Test
//	public void testGetAllItems() throws Exception {
//		List<ItemDetails> itemList = new ArrayList<>();
//		Item item1 = new Item(1000,"Potato",50,user,"Vegetable");
//		Item item2 = new Item(1001,"Tomato",3,user,"Cherry Tomato");
//		itemList.add(
//				new ItemDetails(item1.getItemId(),item1.getItemName(),item1.getItemQuantity(),item1.getUser().getUserName(),item1.getUser().getMobileNumber(),item1.getUser().getUserid()));
//		itemList.add(
//				new ItemDetails(item2.getItemId(),item2.getItemName(),item2.getItemQuantity(),item2.getUser().getUserName(),item2.getUser().getMobileNumber(),item2.getUser().getUserid()));
//
//		given(itemService.getAllItems()).willReturn(itemList);
//
//		ResultActions response = mockMvc.perform(get("/farmmarket/getAllItems"));
//
//		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(itemList.size())));
//	}
//
//	@Test
//	public void testDeleteItemDetails() throws Exception {
//		Item item = new Item(1000,"Potato",50,user,"Vegetable");
//		willDoNothing().given(itemService).deleteItemDetails(item.getItemId());
//
//		ResultActions response = mockMvc.perform(delete("/farmmarket/deleteItemDetails/{itemId}", item.getItemId()));
//		response.andExpect(status().isNoContent()).andDo(print());
//	}
//
//	@Test
//	public void testUpdateItemDetails() throws Exception {
//		Item item = new Item(1000,"Potato",50,user,"Vegetable");
//		Item updatedItem = new Item(1000,"Potato",50,user,"Vegetable Curry");
//		given(userService.findUser(user.getUserid())).willReturn(user);
//		given(itemService.getItemById(item.getItemId())).willReturn(item);
//
//        given(itemService.addNewItem(any(Item.class)))
//                .willAnswer((invocation)-> invocation.getArgument(0));
//
//        ResultActions response = mockMvc.perform(put("/farmmarket/itemDetails/{uid}",user.getUserid())
//                                    .contentType(MediaType.APPLICATION_JSON)
//                                    .content(objectMapper.writeValueAsString(updatedItem)));
//
//        response.andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(jsonPath("$.itemName", is(updatedItem.getItemName())))
//                .andExpect(jsonPath("$.itemType", is(updatedItem.getItemType())))
//                .andExpect(jsonPath("$.itemQuantity", is(updatedItem.getItemQuantity())));
//	}
//
//	@Test
//	public void testAddNewEquipment() throws Exception {
//		Equipment e = new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1);
//
//		given(userService.findUser(user.getUserid())).willReturn(user);
//		given(equipmentService.addEquipment(any(Equipment.class))).willAnswer((invocation) -> invocation.getArgument(0));
//		ResultActions response = mockMvc.perform(post("/farmmarket/addNewEquipment/{id}",user.getUserid())
//				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(e)));
//
//		response.andDo(print()).andExpect(status().isCreated())
//				.andExpect(jsonPath("$.equipmentName", is(e.getEquipmentName())))
//				.andExpect(jsonPath("$.quantityCount", is(e.getQuantityCount())));
//	}
//
//	@Test
//	public void testGetAllEquipments() throws Exception {
//		List<Equipment> eList = new ArrayList<>();
//		eList.add(new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1));
//		eList.add(new Equipment(101,"Tractor","Jack","7536514243",25000,25,"Kerala","Cochin","Trivandrum","200021",user1));
//		eList.add(new Equipment(102,"Tractor","Jim","6736514243",27000,30,"Kerala","Cochin","Trivandrum","600021",user1));
//		given(equipmentService.getAllEquipment()).willReturn(eList);
//
//		ResultActions response = mockMvc.perform(get("/farmmarket/getAllEquipments"));
//
//		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(eList.size())));
//	}
//
//	@Test
//	public void testDeleteEquipmentDetails() throws Exception {
//		Equipment e=new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1);
//		willDoNothing().given(equipmentService).deleteEquipmentDetail(e.getEquipmentId());
//
//		ResultActions response = mockMvc.perform(delete("/farmmarket/deleteEquipmentDetails/{equipId}", e.getEquipmentId()));
//		response.andExpect(status().isNoContent()).andDo(print());
//	}
//
//	@Test
//	public void testUpdateEquipmentDetails() throws Exception {
//		Equipment equipment = new Equipment(100,"Drone","John", "8736514243",30000,20,"Kerala","Cochin","Trivandrum","200021",user1);
//		Equipment updatedEquipment = new Equipment(100,"Drone","John", "8736514243",30000,25,"Kerala","Cochin","Trivandrum","200021",user1);
//		given(userService.findUser(user1.getUserid())).willReturn(user1);
//		given(equipmentService.getEquipmentById(equipment.getEquipmentId())).willReturn(equipment);
//
//        given(equipmentService.addEquipment(any(Equipment.class)))
//                .willAnswer((invocation)-> invocation.getArgument(0));
//
//        ResultActions response = mockMvc.perform(put("/farmmarket/equipmentDetails/{uid}", equipment.getEquipmentId(),user1.getUserid())
//                                    .contentType(MediaType.APPLICATION_JSON)
//                                    .content(objectMapper.writeValueAsString(updatedEquipment)));
//
//        response.andExpect(status().isOk())
//                .andDo(print())
//                .andExpect(jsonPath("$.equipmentName", is(updatedEquipment.getEquipmentName())))
//                .andExpect(jsonPath("$.quantityCount", is(updatedEquipment.getQuantityCount())))
//                .andExpect(jsonPath("$.rentPerday", is(updatedEquipment.getRentPerday())));
//	}
//
//	/*@Test
//	public void testReturnEquipment() throws Exception {
//		Equipment e = Equipment.builder().id(100).name("Drone").count(20).rentPerDay(30000.0).state("Kerela")
//				.city("Cochin").village("Trivandrum").pinCode("300021").contactPerson("John").mobileNumber("8736514243")
//				.status("Available").user(user1).build();
//		EquipmentDetails edetails=EquipmentDetails.builder().bookingId(1).equipmentId(100).equipmentName("Drone").contactPerson("John").mobileNumber("8736514243").quantityCount(2).build();
//		given(equipmentService.getEquipmentById(edetails.getEquipmentId())).willReturn(e);
//		e.setCount(e.getCount() + edetails.getQuantityCount());
//		equipmentService.deleteEquipmentDetail(edetails.getBookingId());
//		given(equipmentService.addEquipment(any(Equipment.class)))
//				.willAnswer((invocation) -> invocation.getArgument(0));
//		ResultActions response = mockMvc.perform(put("/farmmarket/returnEquipment")
//				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(e)));
//
//		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.name", is(e.getName())))
//				.andExpect(jsonPath("$.count", is(e.getCount())));
//	}*/
//
//	@Test
//	public void testGetFarmerDetails() throws Exception {
//		given(userService.findUser(user.getUserid())).willReturn(user);
//		ResultActions response = mockMvc.perform(get("/farmmarket/getFarmer/{id}",user.getUserid()));
//		response.andExpect(status().isOk())
//		        .andDo(print())
//		        .andExpect(jsonPath("$.userName", is(user.getUserName())))
//		        .andExpect(jsonPath("$.role", is(user.getRole().toString())));
//	}
//
//	@Test
//	public void testTraderSearchItem() throws Exception {
//		List<ItemDetails> itemList = new ArrayList<>();
//		Item item1 = new Item(1000,"Potato",50,user,"Vegetable");
//		Item item2 = new Item(1001,"Tomato",30,user,"Cherry Tomato");
//
//		itemList.add(
//				new ItemDetails(item1.getItemId(),item1.getItemName(),item1.getItemQuantity(),item1.getUser().getUserName(),item1.getUser().getMobileNumber(),item1.getUser().getUserid()));
//		itemList.add(
//				new ItemDetails(item2.getItemId(),item2.getItemName(),item2.getItemQuantity(),item2.getUser().getUserName(),item2.getUser().getMobileNumber(),item2.getUser().getUserid()));
//		given(itemService.searchItem("Chennai")).willReturn(itemList);
//
//		ResultActions response = mockMvc.perform(get("/farmmarket/searchItem").param("city", "Chennai"));
//
//		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(itemList.size())));
//
//	}
//
//	@Test
//	public void testOrderItem() throws Exception {
//		Item item = new Item(1000,"Potato",50,user,"Vegetable");
////		Item item2 = new Item(1001,"Tomato",3,user,"Cherry Tomato");
//
//		given(itemService.getItemById(item.getItemId())).willReturn(item);
//		item.setItemQuantity(item.getItemQuantity() - 1);
//		given(itemService.addNewItem(any(Item.class)))
//				.willAnswer((invocation) -> invocation.getArgument(0));
//		ResultActions response = mockMvc.perform(put("/farmmarket/orderItem/{itemId}", item.getItemId())
//				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(item)));
//
//		response.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.itemName", is(item.getItemName())))
//				.andExpect(jsonPath("$.itemQuantity", is(item.getItemQuantity())));
//	}
//
//
//}
