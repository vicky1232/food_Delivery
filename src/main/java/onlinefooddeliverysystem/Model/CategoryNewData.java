package onlinefooddeliverysystem.Model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CategoryNewData {
    private String categoryName;
    private String categoryDescription;
    private String action;

    public CategoryNewData(String categoryName, String categoryDescription, String action) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.action = action;
    }
}
