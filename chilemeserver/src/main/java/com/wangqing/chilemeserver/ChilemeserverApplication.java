package com.wangqing.chilemeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // 开启生成接口文档
public class ChilemeserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChilemeserverApplication.class, args);
    }

}
