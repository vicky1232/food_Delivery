package onlinefooddeliverysystem.Model;

import lombok.Data;

import java.util.List;
@Data
public class FoodCategoriesData {
    private String code;
    private String msg;
   private List<FoodsByCategoriesData> foodsByCategoriesData;
}
