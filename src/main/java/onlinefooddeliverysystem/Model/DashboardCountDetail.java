package onlinefooddeliverysystem.Model;

import lombok.Data;

@Data
public class DashboardCountDetail {
    private CategoryCount categoryCount;
    private FoodCount foodCount;
    private String msg;
    private String code;
@Data
    public static class CategoryCount{

        private String categoryName;
    }
    @Data
    public static class FoodCount{
        private String foodName;
    }

}
