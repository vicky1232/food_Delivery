package onlinefooddeliverysystem.Service;

import onlinefooddeliverysystem.Entity.*;
import onlinefooddeliverysystem.Model.AdminDetail;
import onlinefooddeliverysystem.Model.CategoryNewData;
import onlinefooddeliverysystem.Model.CommonResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface Service {
    CommonResponse saveadmin(Admin adminmodel);

    Admin adminExist(String adminEmail);

    AdminDetail passwordMatch(String adminPassword, Admin admin);

    List getTotalUser();

    List getTotalCategory();

    List getTotalFood();

    List getTotalOrder();

    CommonResponse readDataCategory(MultipartFile file);

    CommonResponse readDataFood(MultipartFile file);

    List<Category> ViewAllCategory();

    boolean deleteCategoryById(Long categoryId);

    List<Food> ViewTotalFoods();

    List<Order> ViewTotalOrders();

    List<User> ViewTotalUsers();

    List<CategoryNewData> getDataBycategoryId(Long categoryId);

    boolean deleteFoodById(Long foodId);

    // CommonResponse deleteCategoryById(Long categoryId);
}
