package lk.icta.foodManagement.foodieLavinia.service;

import lk.icta.foodManagement.foodieLavinia.dto.FoodItemDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FoodItemService {

	//get all items
	List<FoodItemDTO> getAllItems();

	//update recent item
	FoodItemDTO updateItem(Long itemId, FoodItemDTO itemDTO) throws IOException;

	//disble unwanted item
	void disableItem(Long itemId);

//    FoodItemDTO addItemWithCategory(String itemName, double unitPrice, boolean disabled, MultipartFile itemImage, Long foodCategoryId) throws IOException;

	//add new item
	FoodItemDTO addItem(String itemName, double unitPrice, boolean disabled, MultipartFile itemImage,
			Long foodCategoryId) throws IOException;

//	FoodItemDTO addItem(String itemName, double unitPrice, boolean disabled, MultipartFile itemImage) throws IOException;
}
