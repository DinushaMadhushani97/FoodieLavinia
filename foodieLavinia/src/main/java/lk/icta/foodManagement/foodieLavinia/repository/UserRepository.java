package lk.icta.foodManagement.foodieLavinia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.icta.foodManagement.foodieLavinia.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// Find a user by username
	User findByUserName(final String userName);
}
