package com.dnapass.training.controller;

import java.util.List;

import com.dnapass.training.entity.*;
import com.dnapass.training.service.EquipmentService;
import com.dnapass.training.service.ItemService;
import com.dnapass.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farmmarket")
public class FarmMarketController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private UserService userService;

	@Autowired
	private EquipmentService equipmentService;

	//Mapping with /login with requestbody login
	@PostMapping("/login")
	public ResponseEntity<User> checkLogin(@RequestBody Login login) {
		return ResponseEntity.ok(userService.checkLogin(login));
	}

	//Mapping with "/newuser"
	@PostMapping("/newuser")
	public ResponseEntity<User> createUser(@RequestBody User user) {

		return new ResponseEntity(userService.saveUser(user), HttpStatus.CREATED);
	}

	//Mapping with "/search" based on city parameter
	@GetMapping("/search")
	public ResponseEntity<List<Equipment>> farmerSearchEquipment(@RequestParam("city") String city) {
		return ResponseEntity.ok(equipmentService.searchEquipment(city));
	}

	//Mapping with "/getAllEquipment"
	@GetMapping("/getAllEquipment")
	public ResponseEntity<List<Equipment>> getAllEquipment() {
		return ResponseEntity.ok(equipmentService.getAllEquipment());
	}
	
	//Mapping with "/getAllEquipmentById/{id} based on user id
	@GetMapping("/getAllEquipmentById/{id}")
	public ResponseEntity<List<Equipment>> getAllEquipmentById(@PathVariable("id")Integer id) {
		return ResponseEntity.ok(equipmentService.getAllEquipmentById(id));
	}
	
	//Mapping with "/getAllItemById/{id}" based on user id
	@GetMapping("/getAllItemById/{id}")
	public ResponseEntity<List<Item>> getAllItemById(@PathVariable("id")Integer id) {
		return ResponseEntity.ok(itemService.getAllItemById(id));
	}

	// Mapping wih "/book/{equipId}/{userid}/{quantitycount}" to book an equipment based on equipment id, user id and number of quantity
	@PutMapping("/book/{equipId}/{userid}/{quantitycount}")
	public ResponseEntity<Equipment> bookEquipment(@PathVariable("equipId") Integer id,@PathVariable("quantitycount") Integer ecount,@PathVariable("userid")Integer uid) {
		Equipment equipmentUser = new Equipment();
//		equipmentUser.setEquipment(equipmentService.getEquipmentById(id));
		equipmentUser.setEquipmentId(id);
		equipmentUser.setUser(userService.findUser(uid));
		equipmentUser.setCount(ecount);
	    return ResponseEntity.ok(equipmentService.addEquipment(equipmentUser));
	}

	//Mapping with "/addNewItem/{id}" based on particular userid with Item body
	@PostMapping("/addNewItem/{id}")
	public ResponseEntity<Item> addNewItem(@RequestBody Item item, @PathVariable("id") Integer userId) {
		item.setUser(userService.findUser(userId));
		return new ResponseEntity(itemService.addNewItem(item), HttpStatus.CREATED);
	} 

	// Mapping with "/getAllItems" to return all items for traders to view
	@GetMapping("/getAllItems")
	public ResponseEntity<List<ItemDetails>> getAllItems() {
		return ResponseEntity.ok(itemService.getAllItems());
	}

	// Mapping with "/deleteItemDetails/{itemId}" to delete item based on itemId
	@DeleteMapping("/deleteItemDetails/{itemId}")
	public ResponseEntity<HttpStatus> deleteItemDetails(@PathVariable("itemId") Integer itemId) {
		itemService.deleteItemDetails(itemId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	//Mapping with "/itemDetails/{uid}" to update the items based on particular user with body Item
	@PutMapping("/itemDetails/{uid}")
	public ResponseEntity<Item> updateItemDetails(@PathVariable("uid") Integer userId,
			@RequestBody Item item) {
		item.setUser(userService.findUser(userId));
	    return ResponseEntity.ok(itemService.addNewItem(item));
	}

	//Mapping with "/addNewEquipment/{id}" to add new equipment for particular userid with equipment body
	@PostMapping("/addNewEquipment/{id}")
	public ResponseEntity<Equipment> addNewEquipment(@RequestBody Equipment equipment,
			@PathVariable("id") Integer userId) {
		return new ResponseEntity(equipmentService.addEquipment(equipment), HttpStatus.CREATED);
	}

	//Mapping with "/getAllEquipments" to display all equipment for farmer based on count
	@GetMapping("/getAllEquipments")
	public ResponseEntity<List<Equipment>> getAllEquipments() {
		return ResponseEntity.ok(equipmentService.getAllEquipment());
	}

	//Mapping with "/deleteEquipmentDetails/{equipId}" to delete particular equipment based on equipment id
	@DeleteMapping("/deleteEquipmentDetails/{equipId}")
	public ResponseEntity<HttpStatus> deleteEquipmentDetails(@PathVariable("equipId") Integer equipId) {
		equipmentService.deleteEquipmentDetail(equipId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	//Mapping with "/equipmentDetails/{uid}" to update equipment detail based on particular user with equipment body
	@PutMapping("/equipmentDetails/{uid}")
	public ResponseEntity<Equipment> updateEquipmentDetails(
			@PathVariable("uid") Integer userId, @RequestBody Equipment equipment) {
		EquipmentUser equipmentUser = new EquipmentUser();
		equipment.setUser(userService.findUser(userId));
	      return ResponseEntity.ok(equipmentService.addEquipment(equipment));
	}

	//Mapping with "/returnEquipment" to return an equipment and update the count
	@GetMapping("/returnEquipment")
	public ResponseEntity<Equipment> returnEquipment(@RequestBody EquipmentDetails edetails) {
	      return null;
	}
	
	//Mapping with "/getHiredEquipment/{id}" to view hired equipment based on user id
	public ResponseEntity<List<EquipmentDetails>> getHiredEquipment(@PathVariable("id")Integer id) {
		 return null;
	}

	//Mapping with "/searchItem" to search the item by trader based on city
	@GetMapping("/searchItem")
	public ResponseEntity<List<ItemDetails>> traderSearchItem(@RequestParam("city") String city) {

		return ResponseEntity.ok(itemService.searchItem(city));
	}

	// Mapping with "/getFarmer/{id}" to display all items for that farmer based on userid
	@GetMapping("/getFarmer/{id}")
	public ResponseEntity<User> getFarmerDetails(@PathVariable("id") Integer id) {

		return ResponseEntity.ok(userService.findUser(id));
	}

	//Mapping with "/orderItem/{itemId}" by trader based on itemid and update the count of items
	public ResponseEntity<ItemDetails> orderItem(@PathVariable("itemId") Integer id) {
		return null;
	}
}
