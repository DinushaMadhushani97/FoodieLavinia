package lk.icta.foodManagement.foodieLavinia.service;

import lk.icta.foodManagement.foodieLavinia.dto.FoodResponseDTO;
import lk.icta.foodManagement.foodieLavinia.entity.Food;
import lk.icta.foodManagement.foodieLavinia.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    @Transactional
    public FoodResponseDTO uploadFoodWithImage(String name, double price, String venue, MultipartFile file) throws IOException {
        byte[] imageData = file.getBytes();
        Food food = new Food(null, name, price, venue, imageData);
        food = foodRepository.save(food);

        return new FoodResponseDTO(food.getName(), food.getPrice(), "image/jpeg", String.valueOf(imageData.length), "localhost:8080/api/foods/" + food.getFoodId() + "/download");
    }

    @Override
    public byte[] downloadFoodImage(Long foodId) throws Exception {
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        if (foodOptional.isPresent()) {
            Food food = foodOptional.get();
            return food.getData();
        } else {
            throw new Exception("Food with ID " + foodId + " not found");
        }
    }

    @Override
    public FoodResponseDTO getFoodDetails(Long foodId) throws Exception {
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        if (foodOptional.isPresent()) {
            Food food = foodOptional.get();
            return new FoodResponseDTO(food.getName(), food.getPrice(), "image/jpeg", String.valueOf(food.getData().length), "/api/foods/" + food.getFoodId() + "/download");
        } else {
            throw new Exception("Food with ID " + foodId + " not found");
        }
    }

    @Override
    public List<FoodResponseDTO> getAllFoods(int page, int size, String sort) {
        // Create a PageRequest for pagination and sorting.
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sort));

        // Retrieve a page of Food entities.
        Page<Food> foodPage = foodRepository.findAll(pageRequest);
        
        // Convert Page<Food> to List<FoodResponseDTO>.
        List<FoodResponseDTO> foodList = foodPage
                .getContent()
                .stream()
                .map(food -> new FoodResponseDTO(
                        food.getName(),
                        food.getPrice(),
                        "image/jpeg", // Assuming a fixed image type for all records
                        String.valueOf(food.getData().length), // File size as a string
                        "/api/foods/" + food.getFoodId() + "/download"
                ))
                .collect(Collectors.toList());

        return foodList;
    }
}
