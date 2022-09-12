package th.ac.ku.restaurant.model;

import lombok.Data;//library
import lombok.NoArgsConstructor;//library

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor //ความจริงไม่เติม javaJDK ก็สร้างให้
@Entity //class ที่เซฟลงdatabase
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private String email;

//    private LocalDateTime createAt;//ดูว่าสร้างเมื่อไหร่เราจะเก็นในdbแต่ไม่ต้องส่งให้ user

    //พอมีการใส่ anotation ที่เป็น @Data ก็จะทำการสร้าง getter setter ให้เอง
    //anotation @NoArgsConstructor จะสร้าง constructor ที่ไม่มี agument ให้
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
}
