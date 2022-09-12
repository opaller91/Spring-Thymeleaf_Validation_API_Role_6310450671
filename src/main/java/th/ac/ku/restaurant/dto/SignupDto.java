package th.ac.ku.restaurant.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SignupDto {//รับส่งระหว่าง client มาที่ server
    //ใส่ attribute ที่จะรับจาก userเท่านั้น

    @NotBlank
    @Size(min=4, message = "Username must have at least 4 characters")//min=4:usernameอย่างน้อย 4 ตัวอักษร ถ้าuserทำผิดก็มีmessageแจ้ง
    private String username;

    @NotBlank
    @Size(min=8, max=128, message = "Password must have at least 8 characters")
    private String password;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^(ROLE_ADMIN|ROLE_USER)$",
            message = "Role is in an incorrect format.")//@Pattern คือ ต้องเป็นpatternนี้เท่านั้น
            //ตัวstring ที่เป็น role จะเป็นได้แค่ role admin หรือ role user เท่านั้น
    private String role;

    @Email //ตรวจสอบemail
    @NotBlank
    private String email;

}

