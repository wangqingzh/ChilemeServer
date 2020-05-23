package com.wangqing.chilemeserver;

import com.wangqing.chilemeserver.chatroom.ClientManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@MapperScan("com.wangqing.chilemeserver.repository")
public class ChilemeserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChilemeserverApplication.class, args);
        ClientManager.startServer();
    }

}
