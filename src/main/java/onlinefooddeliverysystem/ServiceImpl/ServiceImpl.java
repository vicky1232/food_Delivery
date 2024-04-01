package onlinefooddeliverysystem.ServiceImpl;

import onlinefooddeliverysystem.Entity.*;
import onlinefooddeliverysystem.FileUtilittyValidation;
import onlinefooddeliverysystem.Model.AdminDetail;
import onlinefooddeliverysystem.Model.CategoryNewData;
import onlinefooddeliverysystem.Model.CommonResponse;
import onlinefooddeliverysystem.Repository.*;
import onlinefooddeliverysystem.Service.Service;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private FileUtilittyValidation fileUtilittyValidation;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public CommonResponse saveadmin(Admin adminmodel) {
        CommonResponse commonResponse = new CommonResponse();
        Admin admin = new Admin();
        try {
             adminmodel.setPassword(passwordEncoder.encode(adminmodel.getPassword()));
            adminRepository.save(adminmodel);
            commonResponse.setCode("0000");
            commonResponse.setMsg("data save successfully");
        }catch (Exception e){
            commonResponse.setCode("0000");
            commonResponse.setMsg("error"+e);
        }

        return commonResponse;
    }

    @Override
    public Admin adminExist(String adminEmail) {
        return adminRepository.findAdmin(adminEmail);
    }

    @Override
    public AdminDetail passwordMatch(String adminPassword, Admin admin) {
        AdminDetail adminDetail = new AdminDetail();
        if(passwordEncoder.matches(adminPassword,admin.getPassword())){
         System.out.println("password correct");
         adminDetail.setCode("0000");
         adminDetail.setMsg("Login successfully");
         adminDetail.setId(admin.getId());
         adminDetail.setEmailId(admin.getEmailId());
         adminDetail.setFirstName(admin.getFirstName());
        }else {
         System.out.println("Incorrect password");
         adminDetail.setCode("1111");
         adminDetail.setMsg("Password did not matched");
        }
        return adminDetail;
    }

    @Override
    public List getTotalUser() {
        List users;
        users = userRepository.getUsers();
        return users;
    }

    @Override
    public List getTotalCategory() {
        List category;
        category = categoryRepository.getCategory();
        return category;
    }

    @Override
    public List getTotalFood() {
        List food;
        food = foodRepository.getFood();
        return food;
    }

    @Override
    public List getTotalOrder() {
        List Order;
        Order = orderRepository.getOrder();
        return Order;
    }

    @Override
    public CommonResponse readDataCategory(MultipartFile file) {
        List<Category> categories = new ArrayList<>();
        String errorMsg = "";
        CommonResponse commonResponse = new CommonResponse();
        int count = 0;

        try {

            InputStream inputStream = file.getInputStream();
            ZipSecureFile.setMinInflateRatio(0);                //for zip bomb detected
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Boolean fileFormat = true;
            Row headerRow = rowIterator.next();

            fileFormat = fileUtilittyValidation.CategoryFileFormat(headerRow);
            System.out.println(fileFormat);
            if (fileFormat) {

                System.out.println("file format matched");

                while (rowIterator.hasNext()) {

                    count++;
                    Row row = rowIterator.next();
                    Category category = new Category();


                    for (int i = 0; i < 3; i++) {
                        Cell cell = row.getCell(i);

                        errorMsg = (cell == null || cell.getCellType() == CellType.BLANK) ? "file upload error due to row no " + (row.getRowNum() + 1) + " is empty" : "";

                        if (errorMsg.isEmpty()) {
                            System.out.println("value=" + row.getRowNum());

                            switch (i) {


                                case 0:
                                    category.setCategoryName(row.getCell(0).toString());
                                    break;
                                case 1:
                                    category.setCategoryDescription(row.getCell(1).toString());
                                    break;
                                case 2:
                                    category.setAction(row.getCell(2).toString());
                                    break;
                            }


                        }
                        if (!errorMsg.isEmpty())
                            break;
                    }
                    if (!errorMsg.isEmpty())
                        break;
                    categories.add(category);

                }

            } else {
                //   System.out.println("file format is not matched");
                errorMsg = "file format is not matching or technical issue.";
            }

            System.out.println(errorMsg);
            //System.out.println(count);
        } catch (Exception e) {
            System.out.println(e);
            errorMsg = "file is empty or technical issue.";
        }

        if (errorMsg.isEmpty() && count > 0) {
            categoryRepository.saveAll(categories);
            commonResponse.setCode("0000");
            commonResponse.setMsg("file uploaded successfully " + categories.size() + " row uploaded.");
        } else {
            if (errorMsg.isEmpty()) {
                errorMsg = "file is empty or technical issue";
                System.out.println(errorMsg);
                commonResponse.setCode("1111");
                commonResponse.setMsg(errorMsg);
            } else {
                System.out.println(errorMsg);
                commonResponse.setCode("1111");
                commonResponse.setMsg(errorMsg);
            }
        }

        return commonResponse;
    }

    @Override
    public CommonResponse readDataFood(MultipartFile file) {
        List<Food> foods = new ArrayList<>();
        String errorMsg = "";
        CommonResponse commonResponse = new CommonResponse();
        int count = 0;

        try {

            InputStream inputStream = file.getInputStream();
            ZipSecureFile.setMinInflateRatio(0);                //for zip bomb detected
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Boolean fileFormat = true;
            Row headerRow = rowIterator.next();

            fileFormat = fileUtilittyValidation.FoodFileFormat(headerRow);
            System.out.println(fileFormat);
            if (fileFormat) {

                System.out.println("file format matched");

                while (rowIterator.hasNext()) {

                    count++;
                    Row row = rowIterator.next();
                    Food food = new Food();


                    for (int i = 0; i < 6; i++) {
                        Cell cell = row.getCell(i);

                        errorMsg = (cell == null || cell.getCellType() == CellType.BLANK) ? "file upload error due to row no " + (row.getRowNum() + 1) + " is empty" : "";

                        if (errorMsg.isEmpty()) {
                            System.out.println("value=" + row.getRowNum());

                            switch (i) {


                                case 0:
                                    food.setFoodName(row.getCell(0).toString());
                                    break;
                                case 1:
                                    food.setFoodImage(row.getCell(1).toString());
                                    break;
                                case 2:
                                    food.setFoodDescription(row.getCell(2).toString());
                                    break;
                                case 3:
                                    food.setFoodCategory(row.getCell(3).toString());
                                    break;
                                case 4:
                                    food.setFoodPrice(Double.valueOf(row.getCell(4).toString()));
                                    break;
                                case 5:
                                    food.setFoodDiscount(Double.valueOf(row.getCell(5).toString()));
                                    break;
                            }


                        }
                        if (!errorMsg.isEmpty())
                            break;
                    }
                    if (!errorMsg.isEmpty())
                        break;
                    foods.add(food);

                }

            } else {
                //   System.out.println("file format is not matched");
                errorMsg = "file format is not matching or technical issue.";
            }

            System.out.println(errorMsg);
            //System.out.println(count);
        } catch (Exception e) {
            System.out.println(e);
            errorMsg = "file is empty or technical issue.";
        }

        if (errorMsg.isEmpty() && count > 0) {
            foodRepository.saveAll(foods);
            commonResponse.setCode("0000");
            commonResponse.setMsg("file uploaded successfully " + foods.size() + " row uploaded.");
        } else {
            if (errorMsg.isEmpty()) {
                errorMsg = "file is empty or technical issue";
                System.out.println(errorMsg);
                commonResponse.setCode("1111");
                commonResponse.setMsg(errorMsg);
            } else {
                System.out.println(errorMsg);
                commonResponse.setCode("1111");
                commonResponse.setMsg(errorMsg);
            }
        }

        return commonResponse;
    }

    @Override
    public List<Category> ViewAllCategory() {
        return categoryRepository.findAll();
    }


public boolean deleteCategoryById(Long categoryId) {
    if (categoryRepository.existsById(categoryId)) {
        categoryRepository.deleteById(categoryId);
        return true;
    } else {
        return false;
    }
}

    @Override
    public List<Food> ViewTotalFoods() {
        return foodRepository.findAll();
    }

    @Override
    public List<Order> ViewTotalOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<User> ViewTotalUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<CategoryNewData> getDataBycategoryId(Long categoryId) {
        List<CategoryNewData> categoryList = new ArrayList<>();
        try {
            if (!(categoryId == null )) {
                categoryList = categoryRepository.findDataBycategoryId(categoryId);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return categoryList;
    }

    @Override
    public boolean deleteFoodById(Long foodId) {
        if (foodRepository.existsById(foodId)) {
            categoryRepository.deleteById(foodId);
            return true;
        } else {
            return false;
        }
    }
}

