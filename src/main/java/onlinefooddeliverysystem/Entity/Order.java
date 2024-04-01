package onlinefooddeliverysystem.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders",schema = "online_food_order")
@Data
public class Order {
    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_Id")
    private Long orderId;

    @Column(name = "User_Id")
    private Long userId;

    @Column(name = "User_Name")
    private String userName;

    @Column(name = "User_Email")
    private String userEmail;

    @Column(name = "User_Phone")
    private String userPhone;

    @Column(name = "Food_Title")
    private String foodTitle;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Ord_Date")
    private Date ordDate;

    @Column(name = "Delivery_Date")
    private Date deliveryDate;

    @Column(name = "Delivery_Status")
    private String deliveryStatus;

    @Column(name = "Action")
    private String action;

}
