package onlinefooddeliverysystem.Repository;

import onlinefooddeliverysystem.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    @Query("SELECT ad from Admin ad where ad.emailId=:adminEmail")
    Admin findAdmin(@Param("adminEmail") String adminEmail);
}
