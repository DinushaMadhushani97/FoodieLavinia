package lk.icta.foodManagement.foodieLavinia.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import lk.icta.foodManagement.foodieLavinia.dto.FoodResponseDTO;

public interface FoodService {

    FoodResponseDTO uploadFoodWithImage(String name, double price, String venue, MultipartFile file) throws IOException;

    byte[] downloadFoodImage(Long foodId) throws Exception;

    FoodResponseDTO getFoodDetails(Long foodId) throws Exception;

    List<FoodResponseDTO> getAllFoods(int page, int size, String sort);
}
