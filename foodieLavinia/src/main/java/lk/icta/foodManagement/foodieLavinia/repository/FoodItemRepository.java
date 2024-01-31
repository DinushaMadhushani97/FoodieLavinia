package lk.icta.foodManagement.foodieLavinia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.icta.foodManagement.foodieLavinia.entity.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository <FoodItem, Long> {

}
