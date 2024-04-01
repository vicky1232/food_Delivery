package onlinefooddeliverysystem.Model;
import onlinefooddeliverysystem.Entity.Category;

import java.util.List;

public class CategoryData {
    private String code;
    private String msg;
  private List<Category> categoryList;

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

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
