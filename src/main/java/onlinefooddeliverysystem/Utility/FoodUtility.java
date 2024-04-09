package onlinefooddeliverysystem.Utility;

import org.springframework.stereotype.Service;

@Service
public class FoodUtility {
    public String CountFoodQuery() {
        String foodQuery = "SELECT COUNT(Food_Name) AS CountFoodName from Food";
        return foodQuery;
    }
}
