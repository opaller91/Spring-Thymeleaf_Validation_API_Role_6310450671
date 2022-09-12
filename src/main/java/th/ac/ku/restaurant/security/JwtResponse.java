package th.ac.ku.restaurant.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data //ให้ทำ getter setter ให้
public class JwtResponse {
    //ใช้ @JsonProperty ตอนที่ชื่อไม่ตรง
    @JsonProperty("access_token")
    private String accessToken; //mapJsonกับตัวแปร

    @JsonProperty("expires_in") //ชื่อ field ของ JSON
    private int expiresIn; //ชื่อ field spring booth

    @JsonProperty("token_type")
    private String tokenType;
}
