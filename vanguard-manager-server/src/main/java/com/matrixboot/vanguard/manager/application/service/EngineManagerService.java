package com.matrixboot.vanguard.manager.application.service;

import com.matrixboot.vanguard.manager.application.EngineNodeFactory;
import com.matrixboot.vanguard.manager.application.IEngineNodeVO;
import com.matrixboot.vanguard.manager.domain.entity.EngineNodeEntity;
import com.matrixboot.vanguard.manager.domain.entity.WebsiteInfoEntity;
import com.matrixboot.vanguard.manager.domain.repository.IEngineNodeRepository;
import com.matrixboot.vanguard.manager.domain.repository.IWebsiteRepository;
import com.matrixboot.vanguard.manager.interfaces.dto.EngineAddWebsiteCommand;
import com.matrixboot.vanguard.manager.interfaces.dto.EngineNodeCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

/**
 * create in 2021/8/17 4:42 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@Validated
@AllArgsConstructor
public class EngineManagerService {

    private final IEngineNodeRepository nodeRepository;

    private final IWebsiteRepository websiteRepository;

    public Page<IEngineNodeVO> findAll(Pageable pageable) {
        return nodeRepository.findAllBy(pageable, IEngineNodeVO.class);
    }

    public void addEngineNode(@Valid EngineNodeCommand command) {
        EngineNodeEntity from = EngineNodeFactory.from(command);
        nodeRepository.save(from);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addNewWebsite(@NotNull EngineAddWebsiteCommand command) {
        Optional<EngineNodeEntity> optionalNode = nodeRepository.findById(command.getNodeId());
        optionalNode.ifPresent(engineNode -> {
            Optional<WebsiteInfoEntity> infoEntity = websiteRepository.findById(command.getWebsiteId());
            infoEntity.ifPresent(engineNode::addWebsiteInfo);
        });
    }
}
