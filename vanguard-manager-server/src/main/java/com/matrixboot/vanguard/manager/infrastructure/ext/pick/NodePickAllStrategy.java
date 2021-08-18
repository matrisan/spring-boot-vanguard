package com.matrixboot.vanguard.manager.infrastructure.ext.pick;

import com.matrixboot.vanguard.manager.domain.entity.EngineNodeEntity;
import com.matrixboot.vanguard.manager.domain.repository.IEngineNodeRepository;
import com.matrixboot.vanguard.manager.domain.service.INodePickStrategy;
import com.matrixboot.vanguard.manager.interfaces.dto.WebsiteInfoSyncCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * create in 2021/8/18 4:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
@AllArgsConstructor
public class NodePickAllStrategy implements INodePickStrategy {

    private final IEngineNodeRepository repository;

    @Override
    public List<EngineNodeEntity> pickSomeNodes(WebsiteInfoSyncCommand command) {
        return repository.findAll();
    }
}
