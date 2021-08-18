package com.matrixboot.vanguard.manager.domain.service;


import com.matrixboot.vanguard.manager.domain.entity.EngineNodeEntity;
import com.matrixboot.vanguard.manager.interfaces.dto.WebsiteInfoSyncCommand;

import java.util.List;

/**
 * 选出需要同步网站信息的节点
 *
 * <p>
 * create in 2021/8/16 3:09 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@FunctionalInterface
public interface IRegionPickStrategy {

    List<EngineNodeEntity> pickSomeNodes(WebsiteInfoSyncCommand command);

}


