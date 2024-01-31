package lk.icta.foodManagement.foodieLavinia.entity;

import javax.persistence.*;

@Entity
@Table(name = "food_item")
public class FoodItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String itemName;

	@Lob
	private byte[] itemImage;

	private double unitPrice;
	private boolean disabled;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "food_category_id", referencedColumnName = "id")
	private FoodCategory foodCategory;

	public FoodItem() {

	}

	public FoodItem(Long id, String itemName, byte[] itemImage, double unitPrice, boolean disabled,
			FoodCategory foodCategory) {

		this.id = id;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.unitPrice = unitPrice;
		this.disabled = disabled;
		this.foodCategory = foodCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public byte[] getItemImage() {
		return itemImage;
	}

	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
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

	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}

}
