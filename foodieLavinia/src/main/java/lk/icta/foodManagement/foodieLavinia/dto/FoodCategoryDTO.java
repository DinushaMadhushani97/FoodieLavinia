package lk.icta.foodManagement.foodieLavinia.dto;

import org.springframework.web.multipart.MultipartFile;

public class FoodCategoryDTO {

	//attributes
	private String categoryName;
	private MultipartFile categoryImage;

	//constructor without fields
	public FoodCategoryDTO() {

	}

	//constructor without fields
	public FoodCategoryDTO(String categoryName, MultipartFile categoryImage) {

		this.categoryName = categoryName;
		this.categoryImage = categoryImage;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public MultipartFile getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(MultipartFile categoryImage) {
		this.categoryImage = categoryImage;
	}

}
