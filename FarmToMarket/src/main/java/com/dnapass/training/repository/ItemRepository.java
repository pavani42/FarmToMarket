package com.dnapass.training.repository;

import java.util.List;

import com.dnapass.training.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dnapass.training.entity.Item;
import com.dnapass.training.entity.ItemDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	//Query to display all item details based on their city for all user
//	@Query("select com.dnapass.training.entity.ItemDetails(i.itemId,i.itemName,i.itemQuantity,i.user.userName,i.user.mobileNumber,i.user.userid) from Item i where i.user.city = :city")
//	List<ItemDetails> getItemDetailsBasedCity(@Param("city")String city);

	@Query("select new com.dnapass.training.entity.ItemDetails(i.itemId, i.itemName, i.itemQuantity, i.user.username, i.user.mobileNumber, i.user.id) from Item i where i.user.city = :city")
	List<ItemDetails> getItemDetailsBasedCity(@Param("city") String city);
	//Query to display all items for particular user
	@Query("select item from Item item where item.user.id = :id")
	List<Item> findAllItem(@Param("id")Integer id);
	
	//Query to display all item details with user details for the trader to order 
	@Query("select new com.dnapass.training.entity.ItemDetails(i.itemId,i.itemName,i.itemQuantity,u.username,u.mobileNumber,u.id) from Item i,User u where i.user.id=u.id and i.itemQuantity>0 and i.user.role = 'Trader'")
	List<ItemDetails> findAllItems();
}
