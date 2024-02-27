package com.dnapass.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dnapass.training.entity.Equipment;
import com.dnapass.training.entity.EquipmentDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>{
    //Query to fetch all equipment based on the city and count
	List<Equipment> findByCity(@Param("city")String code);
    
    //Query to fetch all equipment based on particular userid
    @Query("select eq from Equipment eq where eq.user.id = :id")
   List<Equipment> findAllEquipment(Integer id);
   
   //Query to select all equipment if their count is more than 0
   @Query("select eq from Equipment eq where eq.count > 0")
    List<Equipment> findEquipmentByCount();
   
   //Query to display hired equipment details based on particular user id
//   Integer bookingId, Integer equipmentId, String equipmentName, String contactPerson,
//    String mobileNumber, Integer quantityCount
   @Query("select new com.dnapass.training.entity.EquipmentDetails(eq.id, eq.name, eq.contactPerson, eq.mobileNumber, eq.count) from Equipment eq where eq.user.id = :uid")
   List<EquipmentDetails> findHiredEquipment(@Param("uid")Integer id);
   
}
