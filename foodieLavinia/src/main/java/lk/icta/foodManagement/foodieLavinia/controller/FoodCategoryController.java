package lk.icta.foodManagement.foodieLavinia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lk.icta.foodManagement.foodieLavinia.service.FoodCategoryService;
import lk.icta.foodManagement.foodieLavinia.dto.FoodCategoryDTO;
import lk.icta.foodManagement.foodieLavinia.entity.FoodCategory;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api/foods")
public class FoodCategoryController {

	@Autowired
	private FoodCategoryService categoryService;
	
	@GetMapping("/category/list")
	public List<FoodCategory> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@PostMapping("/add")
	public ResponseEntity<FoodCategoryDTO> addItem(@RequestParam("categoryName") String categoryName,
			@RequestParam("categoryImage") MultipartFile categoryImage) throws IOException {
		FoodCategoryDTO foodCategoryDTO = categoryService.addCategory(categoryName, categoryImage);
		return ResponseEntity.status(HttpStatus.CREATED).body(foodCategoryDTO);
	} 

	@PutMapping("/category/update/{categoryId}")
	public FoodCategory updateCategory(@PathVariable Long categoryId, @ModelAttribute FoodCategoryDTO categoryDTO)
			throws IOException {
		return categoryService.updateCategory(categoryId, categoryDTO);
	}

	@PatchMapping("/category/{categoryId}/disable")
	public void disableCategory(@PathVariable Long categoryId) {
		categoryService.disableCategory(categoryId);
	}

}
