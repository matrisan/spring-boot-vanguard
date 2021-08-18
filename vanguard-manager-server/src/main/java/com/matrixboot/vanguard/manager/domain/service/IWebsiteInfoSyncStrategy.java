package com.matrixboot.vanguard.manager.domain.service;


import com.matrixboot.vanguard.manager.domain.entity.EngineNodeEntity;
import com.matrixboot.vanguard.manager.interfaces.dto.WebsiteInfoSyncCommand;

import java.util.List;

/**
 * 网站同步命令的具体实现
 *
 * <p>
 * create in 2021/8/16 3:21 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@FunctionalInterface
public interface IWebsiteInfoSyncStrategy {

    /**
     * 同步
     *
     * @param command  同步网站命令
     * @param nodeList 引擎节点
     */
    void sync(WebsiteInfoSyncCommand command, List<EngineNodeEntity> nodeList);

}
