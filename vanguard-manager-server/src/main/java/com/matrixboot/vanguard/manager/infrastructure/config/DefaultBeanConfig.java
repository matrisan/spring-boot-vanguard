package com.matrixboot.vanguard.manager.infrastructure.config;


import com.matrixboot.vanguard.manager.domain.service.IRecordCheckStrategy;
import com.matrixboot.vanguard.manager.domain.service.IRegionPickStrategy;
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
public class DefaultBeanConfig {

    @Bean
    @ConditionalOnMissingBean
    public IRecordCheckStrategy recordCheckStrategy() {
        return domain -> true;
    }

    @Bean
    @ConditionalOnMissingBean
    public IRegionPickStrategy regionPickStrategy() {
        return command -> new ArrayList<>(0);
    }
}
