package lk.icta.foodManagement.foodieLavinia.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "food_category")
public class FoodCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String categoryName;

	@Lob
	private byte[] categoryImage;

	private boolean disabled;

	@OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
	private List<FoodItem> foodItems;

	public FoodCategory() {

	}

	public FoodCategory(Long id, String categoryName, byte[] categoryImage, boolean disabled,
			List<FoodItem> foodItems) {

		this.id = id;
		this.categoryName = categoryName;
		this.categoryImage = categoryImage;
		this.disabled = disabled;
		this.foodItems = foodItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public byte[] getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(byte[] categoryImage) {
		this.categoryImage = categoryImage;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public List<FoodItem> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<FoodItem> foodItems) {
		this.foodItems = foodItems;
	}

}
