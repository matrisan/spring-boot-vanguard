package com.matrixboot.vanguard.manager.domain.service;


import com.matrixboot.vanguard.manager.domain.entity.EngineNodeEntity;
import com.matrixboot.vanguard.manager.domain.repository.IWebsiteRepository;
import com.matrixboot.vanguard.manager.interfaces.dto.WebsiteInfoSyncCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * create in 2021/8/16 3:36 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Order(1)
@Component
@AllArgsConstructor
public class WebsiteInfoSyncCommandPersistence implements IWebsiteInfoSyncStrategy {

    private final IWebsiteRepository repository;

    @Override
    public void sync(@NotNull WebsiteInfoSyncCommand command, @NotNull List<EngineNodeEntity> nodeList) {
        repository.findById(command.getId()).ifPresent(entity -> nodeList.forEach(one -> one.addWebsiteInfo(entity)));
    }
}
