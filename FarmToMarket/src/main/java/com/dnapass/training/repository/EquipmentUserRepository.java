package com.dnapass.training.repository;

import com.dnapass.training.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dnapass.training.entity.EquipmentUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface EquipmentUserRepository extends JpaRepository<EquipmentUser, Integer>{
    @Query("select equipmentUser.equipment from EquipmentUser equipmentUser where equipmentUser.user.id = ?1")
    List<Equipment> getEquipmentByUser(int userid);

}
