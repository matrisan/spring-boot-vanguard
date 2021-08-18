package com.matrixboot.vanguard.manager.infrastructure.ext.pick;


import com.matrixboot.vanguard.manager.domain.service.INodePickStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

/**
 * <p>
 * create in 2021/8/16 3:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Configuration
public class DefaultNodeBeanConfig {

    @Bean
    @ConditionalOnMissingBean
    public INodePickStrategy regionPickStrategy() {
        return command -> new ArrayList<>(0);
    }
}
