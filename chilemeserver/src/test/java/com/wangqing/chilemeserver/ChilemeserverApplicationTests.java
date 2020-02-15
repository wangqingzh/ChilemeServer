package com.wangqing.chilemeserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wangqing.chilemeserver.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChilemeserverApplicationTests {
    @Autowired
    UserRepository userRepository;
    private final static Logger logger = LoggerFactory.getLogger(ChilemeserverApplicationTests.class);

    @Test
    public void contextLoads()  {
        System.out.println(userRepository.getUserIdByIdentifier("588"));
    }

}
