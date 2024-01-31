package lk.icta.foodManagement.foodieLavinia.service;

import lk.icta.foodManagement.foodieLavinia.dto.FoodCategoryDTO;
import lk.icta.foodManagement.foodieLavinia.entity.FoodCategory;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FoodCategoryService {
	
	//get all food categories
	List<FoodCategory> getAllCategories();

	//update recent food category
	FoodCategory updateCategory(Long categoryId, FoodCategoryDTO categoryDTO) throws IOException;

	//disble the unwanted food category
	void disableCategory(Long categoryId);

	//add new food category
	FoodCategoryDTO addCategory(String categoryName, MultipartFile categoryImage) throws IOException;

}