package fridget.fridget.ingredient;
import fridget.fridget.common.CommonResponse;
import fridget.fridget.ingredient.dto.IngredientsReqDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/user/ingredients")
    public List<UserIngredient> findMyIngredients() {
        return ingredientService.findMyIngredients();

    }

    @PostMapping("/user/ingredients/create")
    public ResponseEntity<CommonResponse> createIngredients(@RequestBody List<IngredientsReqDto> ingredientsReqDtos) {
        List<UserIngredient> userIngredients = ingredientService.createIngredients(ingredientsReqDtos);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK, "Ingredients added!", userIngredients), HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/ingredients/delete")
    public ResponseEntity<CommonResponse> deleteIngredients(@RequestBody List<IngredientsReqDto> ingredientsReqDtos) {
        List<UserIngredient> userIngredient = ingredientService.deleteIngredients(ingredientsReqDtos);
        return new ResponseEntity<>(new CommonResponse(HttpStatus.OK, "Ingredients removed!", userIngredient), HttpStatus.OK);
    }
}
