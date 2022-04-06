package microservices.book.multiplication.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

  public void addCorsMappings(final CorsRegistry registry){
    registry.addMapping("/**").allowedOrigins("http://localhost:3000");
  }

}
