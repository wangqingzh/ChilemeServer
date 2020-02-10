package com.wangqing.chilemeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChilemeserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChilemeserverApplication.class, args);
    }

}
