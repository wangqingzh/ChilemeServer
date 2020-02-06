package com.wangqing.chilemeserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChilemeserverApplicationTests {
    private final static Logger logger = LoggerFactory.getLogger(ChilemeserverApplicationTests.class);

    @Test
    public void contextLoads() {
        logger.info("fdasjlg;rjae;grio");
        logger.debug(new BCryptPasswordEncoder().encode("123"));
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }

}
