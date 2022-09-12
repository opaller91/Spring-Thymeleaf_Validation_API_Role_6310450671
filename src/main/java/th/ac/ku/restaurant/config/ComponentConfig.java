package th.ac.ku.restaurant.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ComponentConfig {

    @Bean //สร้างBeanให้ return ModelMapper
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) { //่ส่ง get postให้ serverอื่นใช้ RestTemplate
        return builder.build();
    }

}
