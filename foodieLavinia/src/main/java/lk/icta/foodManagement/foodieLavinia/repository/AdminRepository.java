package lk.icta.foodManagement.foodieLavinia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.icta.foodManagement.foodieLavinia.entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository <Admin, Long> {
	
	// Find a Admin by username
	Admin findByUserName(String userName);

	

}
