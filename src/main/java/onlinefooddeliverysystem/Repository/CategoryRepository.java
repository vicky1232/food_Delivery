package onlinefooddeliverysystem.Repository;

import onlinefooddeliverysystem.Entity.Category;
import onlinefooddeliverysystem.Model.CategoryNewData;
import onlinefooddeliverysystem.Model.FoodsByCategoriesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("select count(cr.categoryName) from Category cr")
    List getCategory();
    @Query("select new onlinefooddeliverysystem.Model.CategoryNewData(cy.categoryName, cy.categoryDescription, cy.action) from Category cy where cy.categoryId=:categoryId")
    List<CategoryNewData> findDataBycategoryId(Long categoryId);
    @Query("Select new onlinefooddeliverysystem.Model.FoodsByCategoriesData(d.categoryName,pp.foodName,pp.foodImage,pp.foodDescription,pp.foodCategory,pp.foodPrice,pp.foodDiscount) from Category d JOIN Food pp ON d.categoryId=pp.categoryId")
    List<FoodsByCategoriesData> AllFoodByCategory();
}
