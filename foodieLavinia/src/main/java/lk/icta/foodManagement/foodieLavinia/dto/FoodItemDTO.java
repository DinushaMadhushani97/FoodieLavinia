package lk.icta.foodManagement.foodieLavinia.dto;

import org.springframework.web.multipart.MultipartFile;

public class FoodItemDTO {

	private String itemName;
	private double unitPrice;
	private boolean disabled;
	private MultipartFile itemImage;
	private Long foodCategoryId;

	public FoodItemDTO() {

	}

	public FoodItemDTO(String itemName, double unitPrice, boolean disabled, MultipartFile itemImage,
			Long foodCategoryId) {

		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.disabled = disabled;
		this.itemImage = itemImage;
		this.foodCategoryId = foodCategoryId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public MultipartFile getItemImage() {
		return itemImage;
	}

	public void setItemImage(MultipartFile itemImage) {
		this.itemImage = itemImage;
	}

	public Long getFoodCategoryId() {
		return foodCategoryId;
	}

	public void setFoodCategoryId(Long foodCategoryId) {
		this.foodCategoryId = foodCategoryId;
	}

}
