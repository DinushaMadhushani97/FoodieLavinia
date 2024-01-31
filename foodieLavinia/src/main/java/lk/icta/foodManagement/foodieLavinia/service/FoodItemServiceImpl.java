package lk.icta.foodManagement.foodieLavinia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lk.icta.foodManagement.foodieLavinia.dto.FoodItemDTO;
import lk.icta.foodManagement.foodieLavinia.entity.FoodCategory;
import lk.icta.foodManagement.foodieLavinia.entity.FoodItem;
import lk.icta.foodManagement.foodieLavinia.repository.FoodCategoryRepository;
import lk.icta.foodManagement.foodieLavinia.repository.FoodItemRepository;
import java.util.List;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodItemServiceImpl implements FoodItemService {
	@Autowired
	private FoodItemRepository itemRepository;
	
	@Autowired 
	private FoodCategoryRepository categoryRepository;

	// Bussiness Logic for get all items
	@Override
	public List<FoodItemDTO> getAllItems() {
		List<FoodItem> items = itemRepository.findAll();
		return items.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	// Bussiness logic for update recent item
	@Override
	public FoodItemDTO updateItem(Long itemId, FoodItemDTO foodItemDTO) throws IOException {
		Optional<FoodItem> optionalItem = itemRepository.findById(itemId);
		if (optionalItem.isPresent()) {
			FoodItem foodItem = optionalItem.get();
			foodItem.setItemName(foodItemDTO.getItemName());
			foodItem.setUnitPrice(foodItemDTO.getUnitPrice());
			foodItem.setDisabled(foodItemDTO.isDisabled());

			if (foodItemDTO.getItemImage() != null) {
				foodItem.setItemImage(foodItemDTO.getItemImage().getBytes());

			}
			foodItem = itemRepository.save(foodItem);

			return convertToDTO(foodItem);
		}
		return null;
	}

	// Bussiness logic for disable unwanted item
	@Override
	public void disableItem(Long itemId) {
		Optional<FoodItem> optionalItem = itemRepository.findById(itemId);
		if (optionalItem.isPresent()) {
			FoodItem foodItem = optionalItem.get();
			foodItem.setDisabled(true);
			itemRepository.save(foodItem);
		}
	}

	// Bussiness logic for add new item
	@Override
	public FoodItemDTO addItem(String itemName, double unitPrice, boolean disabled, MultipartFile itemImage,
			Long foodCategoryId) throws IOException {
		FoodItemDTO foodItemDTO = new FoodItemDTO();
		foodItemDTO.setItemName(itemName);
		foodItemDTO.setUnitPrice(unitPrice);
		foodItemDTO.setDisabled(disabled);
		foodItemDTO.setFoodCategoryId(foodCategoryId);
		FoodItem foodItem = convertToEntity(foodItemDTO);

		 if (itemImage != null && !itemImage.isEmpty()) {
		        foodItem.setItemImage(itemImage.getBytes());
		    }

		    // Fetch the FoodCategory from the database using foodCategoryId and set it in the FoodItem
		    FoodCategory foodCategory = categoryRepository.findById(foodCategoryId).orElse(null);
		    foodItem.setFoodCategory(foodCategory);

		    FoodItem addItem = itemRepository.save(foodItem);
		    return convertToDTO(addItem);
	}

	// convert item object to DTO
	private FoodItemDTO convertToDTO(FoodItem foodItem) {
		FoodItemDTO foodItemDTO = new FoodItemDTO();
		foodItemDTO.setItemName(foodItem.getItemName());
		foodItemDTO.setUnitPrice(foodItem.getUnitPrice());
		foodItemDTO.setDisabled(foodItem.isDisabled());
		

		return foodItemDTO;
	}

	// convert DTO to item object
	private FoodItem convertToEntity(FoodItemDTO foodItemDTO) {
		FoodItem foodItem = new FoodItem();
		foodItem.setItemName(foodItemDTO.getItemName());
		foodItem.setUnitPrice(foodItemDTO.getUnitPrice());
		foodItem.setDisabled(foodItemDTO.isDisabled());

		return foodItem;
	}

}
