package security;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@SpringBootApplication
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityInitializer.class, args);
    }
}

