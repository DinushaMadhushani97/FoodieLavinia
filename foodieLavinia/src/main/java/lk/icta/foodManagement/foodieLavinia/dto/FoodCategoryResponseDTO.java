package lk.icta.foodManagement.foodieLavinia.dto;

public class FoodCategoryResponseDTO {
    
    private String catName;
    private String catImage;
    private byte[] file;

    public FoodCategoryResponseDTO() {
        
    }

	public FoodCategoryResponseDTO(String catName, String catImage, byte[] file) {
		
		this.catName = catName;
		this.catImage = catImage;
		this.file = file;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatImage() {
		return catImage;
	}

	public void setCatImage(String catImage) {
		this.catImage = catImage;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	

   
}
