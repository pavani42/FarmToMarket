package com.dnapass.training.service;

import java.util.List;

import com.dnapass.training.entity.Equipment;
import com.dnapass.training.entity.EquipmentDetails;
import com.dnapass.training.entity.EquipmentUser;
import com.dnapass.training.repository.EquipmentRepository;
import com.dnapass.training.repository.EquipmentUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService{

	@Autowired
	private EquipmentRepository equipRepo;

	@Autowired
	private EquipmentUserRepository equipmentUserRepository;
	//To search all equipment based on their city 
	public List<Equipment> searchEquipment(String city) {
		return equipRepo.findByCity(city);
	}

	//To fetch all equipmnet for the farmers to book it 
	public List<Equipment> getAllEquipment() {
		List<Equipment> equipmentList = equipRepo.findAll();
		if(equipmentList.isEmpty())
			return null;
		return equipRepo.findAll();
	}

	//To add new equipment 
	public Equipment addEquipment(Equipment e) {
//		EquipmentUser equipmentUser = new EquipmentUser();
//		equipmentUser.setUser(e.getUser());
//		equipmentUser.setEquipment(e);
//		equipmentUser.setQuantity(e.getQuantityCount());
////		equipRepo.save(e.getEquipment());
//		addEquipmentUser(equipmentUser);
//		if(equipRepo.existsById(e.getEquipmentId()))
//		{
//			Equipment equip = equipRepo.findById(e.getEquipmentId()).get();
//			equip.setQuantityCount(e.getQuantityCount());
//			equip.setUser(e.getUser());
//		}
//		equipmentUserRepository.save(equipmentUser);
		return equipRepo.save(e);
	}

    //To delete particular equipment based on equipment id 
	public void deleteEquipmentDetail(Integer equipId) {
		equipRepo.deleteById(equipId);
	}

   //To get an equipment based on id 
	public Equipment getEquipmentById(Integer id) {
		return equipRepo.findById(id).get();
	}

    //To fetch all equipment for that particular user 
	public List<Equipment> getAllEquipmentById(Integer id) {
		return equipmentUserRepository.getEquipmentByUser(id);
	}
	
	//To fetch all hired equipment for particular user 
	public List<EquipmentDetails> getHiredEquipment(Integer uid){
		return null;
	}
	
	//To add new equipmentuser which contains both equipment details and user details 
	public EquipmentUser addEquipmentUser(EquipmentUser euser) {

		return equipmentUserRepository.save(euser);
	}
	
	//To delete equipment based on bookingid while returning the equipment
	public void deleteEquipmentUser(Integer bookingId) {
		equipmentUserRepository.deleteById(bookingId);
	}
}
