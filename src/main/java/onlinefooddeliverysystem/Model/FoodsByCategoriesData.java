package onlinefooddeliverysystem.Model;

import lombok.Data;
@Data
public class FoodsByCategoriesData {
        private String categoryName;
        private String foodName;
        private String foodImage;
        private String foodDescription;
        private String foodCategory;
        private Double foodPrice;
        private Double foodDiscount;

        public FoodsByCategoriesData(String categoryName, String foodName, String foodImage, String foodDescription, String foodCategory, Double foodPrice, Double foodDiscount) {
                this.categoryName = categoryName;
                this.foodName = foodName;
                this.foodImage = foodImage;
                this.foodDescription = foodDescription;
                this.foodCategory = foodCategory;
                this.foodPrice = foodPrice;
                this.foodDiscount = foodDiscount;
        }
}


