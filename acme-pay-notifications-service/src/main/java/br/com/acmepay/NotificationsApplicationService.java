package br.com.acmepay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationsApplicationService {
    public static void main(String[] args) {
        //System.setProperty("spring.amqp.deserialization.trust.all", "true");
        SpringApplication.run(NotificationsApplicationService.class, args);
    }
}