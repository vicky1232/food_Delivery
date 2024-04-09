package onlinefooddeliverysystem.Utility;

import org.springframework.stereotype.Service;

@Service
public class CategoryUtility {
    public String CountCategoryQuery() {
        String categoryQuery = "SELECT COUNT(Category_Name) AS CountCategoryName from Category";
        return categoryQuery;
    }
}
