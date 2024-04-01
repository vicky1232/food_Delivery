package onlinefooddeliverysystem.Model;

import lombok.Data;
import onlinefooddeliverysystem.Entity.Category;

import java.util.List;
@Data
public class CategoryIdData {
    private String code;
    private String msg;
    private List<CategoryNewData> categoryList;


}
