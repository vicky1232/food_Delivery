package onlinefooddeliverysystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user",schema = "online_food_order")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private long userId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email_Id")
    private String emailId;

    @Column(name = "Mobile")
    private String mobile;

    @Column(name = "Address")
    private String address;
}
