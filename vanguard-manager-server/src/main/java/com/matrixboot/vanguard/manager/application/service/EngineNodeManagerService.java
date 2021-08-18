package com.matrixboot.vanguard.manager.application.service;

import com.matrixboot.vanguard.manager.application.EngineNodeFactory;
import com.matrixboot.vanguard.manager.application.IEngineNodeVO;
import com.matrixboot.vanguard.manager.domain.entity.EngineNodeEntity;
import com.matrixboot.vanguard.manager.domain.repository.IEngineNodeRepository;
import com.matrixboot.vanguard.manager.interfaces.dto.EngineNodeCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

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
public class EngineNodeManagerService {

    private final IEngineNodeRepository repository;

    public Page<IEngineNodeVO> findAll(Pageable pageable) {
        return repository.findAllBy(pageable, IEngineNodeVO.class);
    }

    public void addEngineNode(@Valid EngineNodeCommand command) {
        EngineNodeEntity from = EngineNodeFactory.from(command);
        repository.save(from);
    }

}
