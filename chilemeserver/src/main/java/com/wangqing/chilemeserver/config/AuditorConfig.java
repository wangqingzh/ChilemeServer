package com.wangqing.chilemeserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.Random;

/**
 * JPA配置信息
 * 为使@CreateBy生效
 */
@Configuration
public class AuditorConfig implements AuditorAware<Integer> {
    /**
     * 返回操作员标志信息
     * @return
     */
    @Override
    public Optional<Integer> getCurrentAuditor() {
        // 这里应根据实际业务情况获取具体信息
        return Optional.of(new Random().nextInt(100));
    }
}
