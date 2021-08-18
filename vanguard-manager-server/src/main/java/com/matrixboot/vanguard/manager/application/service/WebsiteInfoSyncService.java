package com.matrixboot.vanguard.manager.application.service;


import com.matrixboot.vanguard.manager.domain.service.IRegionPickStrategy;
import com.matrixboot.vanguard.manager.domain.service.IWebsiteInfoSyncStrategy;
import com.matrixboot.vanguard.manager.interfaces.dto.WebsiteInfoSyncCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * create in 2021/8/16 3:04 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@Validated
@AllArgsConstructor
public class WebsiteInfoSyncService implements InitializingBean {

    private final IRegionPickStrategy service;

    private final List<IWebsiteInfoSyncStrategy> list;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void websiteInfoSync(@Valid WebsiteInfoSyncCommand command) {
        list.forEach(one -> one.sync(command, service.pickSomeNodes(command)));
    }

    /**
     * 对网站信息同步命令进行排序
     */
    @Override
    public void afterPropertiesSet() {
        AnnotationAwareOrderComparator.sort(list);
    }
}
