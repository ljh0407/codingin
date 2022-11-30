package codingin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityListeners;

@SpringBootApplication
@EnableJpaAuditing
public class WebStart {
    public static void main(String[] args) {
        SpringApplication.run(WebStart.class);
    }
}
