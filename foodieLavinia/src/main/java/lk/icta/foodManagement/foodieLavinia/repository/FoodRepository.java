package lk.icta.foodManagement.foodieLavinia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.icta.foodManagement.foodieLavinia.entity.Food;


@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{


}
