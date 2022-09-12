package th.ac.ku.restaurant.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class JwtAccessTokenService {
    @Value("${auth0.audience}")
    private String audience;

    @Value("${auth0.clientId}")
    private String clientId;

    @Value("${auth0.clientSecret}")
    private String clientSecret;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;

    @Autowired //เอาไว้ get post
    private RestTemplate restTemplate;

    private String token = null;

    public String requestAccessToken() {

        if (token != null) //ถ้าtokenยังไม่ null(expire)ก็เอามาใช้ได้เลย
            return token;

        HttpHeaders headers = new HttpHeaders();//request
        headers.add("Content-Type",
                MediaType.APPLICATION_FORM_URLENCODED.toString());

        //เป็น map ตอนส่งเป็น key value
        MultiValueMap<String, String> requestBody =
                new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "client_credentials");
        requestBody.add("client_id", clientId);
        requestBody.add("client_secret", clientSecret);
        requestBody.add("audience", audience);

        //สร้าง HttpEntity ก้อนอันนึงที่ผูกติด requestBody กับ headers
        HttpEntity entity = new HttpEntity(requestBody, headers);

        ResponseEntity<JwtResponse> response =
                restTemplate.exchange(issuer + "oauth/token",
                        HttpMethod.POST,//บอกว่าเอา POST
                        entity, JwtResponse.class);//method exchange ใช้ในการส่ง
        //จะได้ ResponseEntity ที่มีก้อน JwtResponse

        JwtResponse jwtResponse = response.getBody();//เอาแค่JwtResponse
        token = jwtResponse.getAccessToken();//saveไว้ที่tokenเอาไว้ใช้งาน

        System.out.println(jwtResponse);
        System.out.println(token);
        return token;
    }
}
