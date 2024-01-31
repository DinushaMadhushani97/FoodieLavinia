package lk.icta.foodManagement.foodieLavinia.dto;

public class FoodResponseDTO {

    private String name;
    private double price;
    private String fileType;
    private String fileSize;
    private String downloadUrl;
	public FoodResponseDTO() {
		
	}
	public FoodResponseDTO(String name, double price, String fileType, String fileSize, String downloadUrl) {
		
		this.name = name;
		this.price = price;
		this.fileType = fileType;
		this.fileSize = fileSize;
		this.downloadUrl = downloadUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

    
}
