package onlinefooddeliverysystem.Repository;

import onlinefooddeliverysystem.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    @Query("select count(fd.foodName) from Food fd")
    List getFood();
}
