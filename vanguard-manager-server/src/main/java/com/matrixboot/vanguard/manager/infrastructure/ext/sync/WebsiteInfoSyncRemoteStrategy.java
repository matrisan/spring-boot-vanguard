package com.matrixboot.vanguard.manager.infrastructure.ext.sync;

import com.matrixboot.vanguard.manager.domain.entity.EngineNodeEntity;
import com.matrixboot.vanguard.manager.domain.service.INodeReleaseConverter;
import com.matrixboot.vanguard.manager.domain.service.IRemoteSyncStrategy;
import com.matrixboot.vanguard.manager.domain.service.IWebsiteInfoSyncStrategy;
import com.matrixboot.vanguard.manager.interfaces.dto.WebsiteInfoSyncCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * create in 2021/8/18 2:19 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Order(2)
@Component
@AllArgsConstructor
public class WebsiteInfoSyncRemoteStrategy implements IWebsiteInfoSyncStrategy {

    private final Map<String, INodeReleaseConverter> releaseConverterMap;

    private final Map<String, IRemoteSyncStrategy> syncStrategyMap;

    @Override
    public void sync(@NotNull WebsiteInfoSyncCommand command, @NotNull List<EngineNodeEntity> nodeList) {
        nodeList.forEach(nodeEntity -> nodeEntity.startToSync(command.getId(), releaseConverterMap, syncStrategyMap));
    }
}


