package lk.icta.foodManagement.foodieLavinia.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lk.icta.foodManagement.foodieLavinia.dto.FoodResponseDTO;
import lk.icta.foodManagement.foodieLavinia.service.FoodService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api/foods")
public class FoodController {

	private final FoodService foodService;

	@Autowired
	public FoodController(FoodService foodService) {
		this.foodService = foodService;
	}

	@PostMapping("/upload")
	public ResponseEntity<FoodResponseDTO> uploadFoodWithImage(
			@RequestParam("file") MultipartFile file,
			@RequestParam("name") String name, 
			@RequestParam("price") double price, 
			@RequestParam("venue") String venue)
			throws IOException {
		FoodResponseDTO foodResponse = foodService.uploadFoodWithImage(name, price, venue, file);
		return ResponseEntity.ok(foodResponse);
	}

	@GetMapping("/{foodId}/download")
	public ResponseEntity<byte[]> downloadFoodImage(@PathVariable Long foodId) throws Exception {
		byte[] imageBytes = foodService.downloadFoodImage(foodId);
		return ResponseEntity.ok().header("Content-Disposition", "attachment; filename=image.jpg").body(imageBytes);
	}

	@GetMapping("/{foodId}")
	public ResponseEntity<FoodResponseDTO> getFoodDetails(@PathVariable Long foodId) throws Exception {
		FoodResponseDTO foodResponse = foodService.getFoodDetails(foodId);
		return ResponseEntity.ok(foodResponse);
	}

	@GetMapping("/list")
	public ResponseEntity<List<FoodResponseDTO>> getAllFoods(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sort", defaultValue = "foodId") String sort) {
		List<FoodResponseDTO> foodList = foodService.getAllFoods(page, size, sort);
		return ResponseEntity.ok(foodList);
	}
}
