package com.example.calendar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@OpenAPIDefinition(info = @Info(
        title = "Small calendar application",
        contact = @Contact(
                name = "Mano Lemmens",
                email = "lemmensmano@gmail.com"),
        license = @License(
                name = "GPL v3 License",
                url = "https://www.gnu.org/licenses/gpl-3.0.html"),
        version = "0.2b-rc"))
public class CalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarApplication.class, args);
    }
}
