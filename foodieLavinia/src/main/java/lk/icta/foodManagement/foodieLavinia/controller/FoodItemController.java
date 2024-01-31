package lk.icta.foodManagement.foodieLavinia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lk.icta.foodManagement.foodieLavinia.dto.FoodItemDTO;
import lk.icta.foodManagement.foodieLavinia.service.FoodItemService;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api/foods")
public class FoodItemController {

	@Autowired
	private FoodItemService itemService;

	// get all items
	@GetMapping("/items/list")
	public List<FoodItemDTO> getAllItems() {
		return itemService.getAllItems();
	}

//	//add new items
//	@PostMapping("/items/add")
//	public ResponseEntity<FoodItemDTO> addItem(
//			@RequestParam("itemName") String itemName,
//			@RequestParam("unitPrice") double unitPrice,
//			@RequestParam("disabled") boolean disabled,
//			@RequestParam("itemImage") MultipartFile itemImage) throws IOException {
//		FoodItemDTO foodItemDTO = itemService.addItem(itemName, unitPrice, disabled, itemImage);
//		return ResponseEntity.status(HttpStatus.CREATED).body(foodItemDTO);
//	}

	//add new items
	@PostMapping("/items/add")
	public ResponseEntity<FoodItemDTO> addItem(@RequestParam("itemName") String itemName,
			@RequestParam("unitPrice") double unitPrice, 
			@RequestParam("disabled") boolean disabled,
			@RequestParam("itemImage") MultipartFile itemImage, 
			@RequestParam("foodCategoryId") Long foodCategoryId)
			throws IOException {
		FoodItemDTO foodItemDTO = itemService.addItem(itemName, unitPrice, disabled, itemImage, foodCategoryId);
		if (foodItemDTO != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(foodItemDTO);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	// update recent item
	@PutMapping("/items/{itemId}")
	public FoodItemDTO updateItem(@PathVariable Long itemId, @ModelAttribute FoodItemDTO itemDTO) throws IOException {
		return itemService.updateItem(itemId, itemDTO);
	}

	// disable unwanted item
	@PatchMapping("/items/{itemId}/disable")
	public void disableItem(@PathVariable Long itemId) {
		itemService.disableItem(itemId);
	}

}
