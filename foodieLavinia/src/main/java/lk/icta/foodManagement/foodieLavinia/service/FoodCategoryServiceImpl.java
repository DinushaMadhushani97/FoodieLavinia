package lk.icta.foodManagement.foodieLavinia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lk.icta.foodManagement.foodieLavinia.dto.FoodCategoryDTO;
import lk.icta.foodManagement.foodieLavinia.entity.FoodCategory;
import lk.icta.foodManagement.foodieLavinia.repository.FoodCategoryRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FoodCategoryServiceImpl implements FoodCategoryService {

	@Autowired
	private FoodCategoryRepository categoryRepository;

	//Bussiness logic to get all categories
	@Override
	public List<FoodCategory> getAllCategories() {
		return categoryRepository.findAll();
	}

	//Bussiness logic to update recent category
	@Override
	public FoodCategory updateCategory(Long categoryId, FoodCategoryDTO categoryDTO) throws IOException {
		Optional<FoodCategory> optionalCategory = categoryRepository.findById(categoryId);
		if (optionalCategory.isPresent()) {
			FoodCategory category = optionalCategory.get();
			category.setCategoryName(categoryDTO.getCategoryName());
			if (categoryDTO.getCategoryImage() != null) {
				category.setCategoryImage(categoryDTO.getCategoryImage().getBytes());

			}
			category = categoryRepository.save(category);
			return category;
		}
		return null;
	}

	//Bussiness logic for disable unwanted category
	@Override
	public void disableCategory(Long categoryId) {
		Optional<FoodCategory> optionalCategory = categoryRepository.findById(categoryId);
		if (optionalCategory.isPresent()) {
			FoodCategory category = optionalCategory.get();
			category.setDisabled(true);
			categoryRepository.save(category);
		}
	}


	//Bussiness logic for create new category
	@Override
	public FoodCategoryDTO addCategory(String categoryName, MultipartFile categoryImage) throws IOException {
		FoodCategoryDTO foodCategoryDTO = new FoodCategoryDTO();
		foodCategoryDTO.setCategoryName(categoryName);

		FoodCategory foodCategory = convertToEntity(foodCategoryDTO);

		if (categoryImage != null && !categoryImage.isEmpty()) {
			foodCategory.setCategoryImage(categoryImage.getBytes());
		}

		FoodCategory addCategory = categoryRepository.save(foodCategory);
		return convertToDTO(addCategory);
	}

	//convert object to DTO
	private FoodCategoryDTO convertToDTO(FoodCategory foodCategory) {
		FoodCategoryDTO foodCategoryDTO = new FoodCategoryDTO();
		foodCategoryDTO.setCategoryName(foodCategory.getCategoryName());

		return foodCategoryDTO;
	}

	//convert DTO to object
	private FoodCategory convertToEntity(FoodCategoryDTO foodCategoryDTO) {
		FoodCategory foodCategory = new FoodCategory();
		foodCategory.setCategoryName(foodCategoryDTO.getCategoryName());

		return foodCategory;
	}

}
