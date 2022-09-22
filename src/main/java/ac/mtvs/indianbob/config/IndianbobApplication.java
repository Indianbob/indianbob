package ac.mtvs.indianbob.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ac.mtvs.indianbob")
public class IndianbobApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndianbobApplication.class, args);
    }

}
