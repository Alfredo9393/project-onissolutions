package pl.piomin.service.kubemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReceiveKubeMQ {

    public static void main(String[] args) {
        SpringApplication.run(ReceiveKubeMQ.class, args);
    }

}
