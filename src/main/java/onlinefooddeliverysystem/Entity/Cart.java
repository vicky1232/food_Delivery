package onlinefooddeliverysystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "cart", schema = "online_food_order")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Cart_ID")
    private Long cartID;

    @Column(name = "Food_Image")
    private String foodImage;

    @Column(name = "Food_Title")
    private String foodTitle;

    @Column(name = "Food_Description")
    private String foodDescription;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Date")
    private LocalDateTime date;

    @Column(name = "Action")
    private String action;
}
