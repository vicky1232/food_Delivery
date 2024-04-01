package onlinefooddeliverysystem.Controller;

import onlinefooddeliverysystem.Entity.*;
import onlinefooddeliverysystem.Model.*;
import onlinefooddeliverysystem.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Service service;

    @PostMapping("/adminRegister")
    public CommonResponse admin(@RequestBody Admin adminmodel) {
        CommonResponse commonResponse = new CommonResponse();
        String email = adminmodel.getEmailId();
        if (email != null && email.contains("@gmail")) {
            commonResponse = service.saveadmin(adminmodel);

        } else {
            commonResponse.setCode("1111");
            commonResponse.setMsg("invalid email");
        }
        return commonResponse;
    }

    @PostMapping("/adminlogin")
    public ResponseEntity<AdminDetail> loginAuthentication(@RequestBody Admin adminRequest) {

        Admin admin = new Admin();
        AdminDetail adminDetail = new AdminDetail();
        String adminEmail = adminRequest.getEmailId();
        String adminPassword = adminRequest.getPassword();

        try {
            if (!adminEmail.isEmpty() && adminEmail.contains("@gmail") && !adminPassword.isEmpty()) {
                admin = service.adminExist(adminEmail);

                if (admin != null) {
                    adminDetail = service.passwordMatch(adminPassword, admin);

                } else {
                    System.out.println("Invalid email");
                    adminDetail.setCode("1111");
                    adminDetail.setMsg("Admin does not exit");
                }
            } else {
                System.out.println("Invalid email");
                adminDetail.setCode("1111");
                adminDetail.setMsg("Invalid admin email");
            }
        } catch (Exception e) {
            System.out.println(e);
            adminDetail.setCode("1111");
            adminDetail.setMsg("Technical issue");
        }
        return new ResponseEntity<AdminDetail>(adminDetail, HttpStatus.OK);
    }

    @GetMapping("/dashboardTotalUser")
    public List userDetail() {
        return service.getTotalUser();
    }


    @GetMapping("/dashboardTotalCategory")
    public List categoryDetail() {
        return service.getTotalCategory();
    }


    @GetMapping("/dashboardTotalFood")
    public List FoodDetail() {
        return service.getTotalFood();
    }


    @GetMapping("/dashboardTotalOrder")
    public List OrderDetail() {
        return service.getTotalOrder();
    }


    @PostMapping("/AddCategory")
    public ResponseEntity<CommonResponse> CategoryFileUpload(@RequestParam("file") MultipartFile file) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse = service.readDataCategory(file);
        return new ResponseEntity<CommonResponse>(commonResponse, HttpStatus.OK);
    }

    @PostMapping("/AddFood")
    public ResponseEntity<CommonResponse> FoodFileUpload(@RequestParam("file") MultipartFile file){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse = service.readDataFood(file);
        return new ResponseEntity<CommonResponse>(commonResponse, HttpStatus.OK);
    }

   @GetMapping("/ViewCategory")
   public ResponseEntity<CategoryData> ViewCategory(){
    List<Category> categories = new ArrayList<>();
       CategoryData categoryData = new CategoryData();
       categories = service.ViewAllCategory();
       if(categories.isEmpty()){
           categoryData.setCode("1111");
           categoryData.setMsg("Data not found");
           categoryData.setCategoryList(null);
       }else {
           categoryData.setCode("0000");
           categoryData.setMsg("Data found successfully");
           categoryData.setCategoryList(categories);

       }
       return new ResponseEntity<CategoryData>(categoryData, HttpStatus.OK);
   }


    @DeleteMapping("/categories/{categoryId}")
    public ResponseEntity<CategoryData> deleteCategory(@PathVariable Long categoryId) {
        CategoryData categoryData = new CategoryData();

        boolean deleted = service.deleteCategoryById(categoryId);

        if (deleted) {
            categoryData.setCode("0000");
            categoryData.setMsg("Category deleted successfully");
            //categoryData.setCategoryList(null);
            return new ResponseEntity<>(categoryData, HttpStatus.OK);
        } else {
            categoryData.setCode("1111");
            categoryData.setMsg("Category not found");
            //categoryData.setCategoryList(null);
            return new ResponseEntity<>(categoryData, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/ViewTotalFoods")
    public ResponseEntity<FoodData> ViewTotalFoods(){
        List<Food> foods = new ArrayList<>();
        FoodData foodData = new FoodData();
        foods = service.ViewTotalFoods();
        if(foods.isEmpty()){
            foodData.setCode("1111");
            foodData.setMsg("Data not found");
            foodData.setFoodList(foods);
        }else {
            foodData.setCode("0000");
            foodData.setMsg("Data found successfully");
            foodData.setFoodList(foods);
        }
        return new ResponseEntity<FoodData>(foodData, HttpStatus.OK);
    }


    @GetMapping("/ViewTotalOrders")
    public ResponseEntity<OrderData> ViewTotalOrders(){
        List<Order>orders = new ArrayList<>();
        OrderData orderData = new OrderData();
        orders = service.ViewTotalOrders();
        if(orders.isEmpty()){
            orderData.setCode("1111");
            orderData.setMsg("Data not found");
            orderData.setOrderList(orders);
        }else {
            orderData.setCode("0000");
            orderData.setMsg("Data found successfully");
            orderData.setOrderList(orders);
        }
        return new ResponseEntity<OrderData>(orderData, HttpStatus.OK);
    }


    @GetMapping("/ViewTotalUsers")
    public ResponseEntity<UserData> ViewTotalUsers(){
        List<User> users = new ArrayList<>();
        UserData userData = new UserData();
        users = service.ViewTotalUsers();
        if(users.isEmpty()){
            userData.setCode("1111");
            userData.setMsg("Data not found");
            userData.setUserList(users);
        }else {
            userData.setCode("0000");
            userData.setMsg("Data found successfully");
            userData.setUserList(users);
        }
        return new ResponseEntity<UserData>(userData, HttpStatus.OK);
    }

    @GetMapping("/getFoodByCategories")
    public CategoryIdData getFoodByCategories(@RequestParam Long categoryId) {
        CategoryIdData categoryIdData = new CategoryIdData();
        List<CategoryNewData> categoryList = new ArrayList<>();
        categoryList = service.getDataBycategoryId(categoryId);
        if(!(categoryList.isEmpty())){
            categoryIdData.setCode("1111");
            categoryIdData.setMsg("Data not found");
            categoryIdData.setCategoryList(categoryList);
        }else {
            categoryIdData.setCode("0000");
            categoryIdData.setMsg("Data found successfully");
            categoryIdData.setCategoryList(categoryList);
        }

        return categoryIdData;
    }


    @DeleteMapping("/food/{foodId}")
    public ResponseEntity<FoodData> deleteFood(@PathVariable Long foodId) {
        FoodData  foodData= new FoodData();

        boolean deleted = service.deleteFoodById(foodId);

        if (deleted) {
            foodData.setCode("0000");
            foodData.setMsg("Food deleted successfully");
            //categoryData.setCategoryList(null);
            return new ResponseEntity<>(foodData, HttpStatus.OK);
        } else {
            foodData.setCode("1111");
            foodData.setMsg("Food not found");
            //categoryData.setCategoryList(null);
            return new ResponseEntity<>(foodData, HttpStatus.NOT_FOUND);
        }
    }
}

