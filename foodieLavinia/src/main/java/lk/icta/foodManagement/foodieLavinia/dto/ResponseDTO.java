package lk.icta.foodManagement.foodieLavinia.dto;

public class ResponseDTO {

	private Long itemId;
	private String itemName;
	private double unitPrice;
	private byte[] itemImage;
	private Long catId;
	private String catName;
	private byte[] catImage;
	
	public ResponseDTO() {
		
	}
	public ResponseDTO(Long itemId, String itemName, double unitPrice, byte[] itemImage, Long catId, String catName,
			byte[] catImage) {
		
		this.itemId = itemId;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.itemImage = itemImage;
		this.catId = catId;
		this.catName = catName;
		this.catImage = catImage;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
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
	public byte[] getItemImage() {
		return itemImage;
	}
	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
	}
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public byte[] getCatImage() {
		return catImage;
	}
	public void setCatImage(byte[] catImage) {
		this.catImage = catImage;
	}
	
	
	
	

}
