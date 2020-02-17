package com.wangqing.chilemeserver;

import com.wangqing.chilemeserver.repository.PostRepository;
import com.wangqing.chilemeserver.repository.UserRepository;
import com.wangqing.chilemeserver.service.MineService;
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

    @Autowired
    PostRepository postRepository;

    @Autowired
    MineService mineService;

    private final static Logger logger = LoggerFactory.getLogger(ChilemeserverApplicationTests.class);

    @Test
    public void contextLoads()  {
        System.out.println(mineService.getUserInfoDtoByUserId(0));
    }

}
