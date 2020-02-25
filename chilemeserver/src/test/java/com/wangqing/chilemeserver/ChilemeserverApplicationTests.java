package com.wangqing.chilemeserver;

import com.wangqing.chilemeserver.object.dto.FoodRecBrowserDto;
import com.wangqing.chilemeserver.repository.FoodRecMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChilemeserverApplicationTests {
    @Autowired
    FoodRecMapper foodRecMapper;

    private final static Logger logger = LoggerFactory.getLogger(ChilemeserverApplicationTests.class);

    @Test
    public void test() throws IOException {

        List<FoodRecBrowserDto> tests = foodRecMapper.foodRecBrowserByClassifyId(1,2);
        for (FoodRecBrowserDto t: tests
             ) {
            System.out.println(t);
        }
    }
}
