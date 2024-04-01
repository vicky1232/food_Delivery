package onlinefooddeliverysystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "food",schema = "online_food_order")
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Food_Id")
    private Long foodId;

    @Column(name = "Food_Name")
    private String foodName;

    @Column(name = "Food_Image")
    private String foodImage;

    @Column(name = "Food_Description")
    private String foodDescription;

    @Column(name = "Food_Category")
    private String foodCategory;

    @Column(name = "Food_Price")
    private Double foodPrice;

    @Column(name = "Food_Discount")
    private Double foodDiscount;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "Category_Id")
//    private User user;
}
