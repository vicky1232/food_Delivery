package onlinefooddeliverysystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "admin",schema = "online_food_order")
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @Column(name = "city")
    private String city;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "password")
    private String password;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "street")
    private String street;
}
