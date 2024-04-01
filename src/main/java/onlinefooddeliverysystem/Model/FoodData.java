package onlinefooddeliverysystem.Model;

import onlinefooddeliverysystem.Entity.Food;

import java.util.List;

public class FoodData {
    private String code;
    private String msg;
    private List<Food> foodList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
