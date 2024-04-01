package onlinefooddeliverysystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category",schema = "online_food_order")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Category_Id")
    private Long categoryId;

    @Column(name = "Category_Name")
    private String categoryName;

    @Column(name = "Category_Description")
    private String categoryDescription;

    @Column(name = "Action")
    private String action;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Food> foods;

}