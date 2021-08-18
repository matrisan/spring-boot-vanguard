package com.matrixboot.vanguard.manager.application.service;


import com.matrixboot.vanguard.manager.application.WebsiteFactory;
import com.matrixboot.vanguard.manager.domain.entity.WebsiteInfoEntity;
import com.matrixboot.vanguard.manager.domain.repository.IWebsiteRepository;
import com.matrixboot.vanguard.manager.domain.service.IRecordCheckStrategy;
import com.matrixboot.vanguard.manager.interfaces.dto.WebsiteAddCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * <p>
 * create in 2021/8/16 2:47 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@AllArgsConstructor
@Service
@Validated
public class WebsiteManagerService {

    private final IRecordCheckStrategy service;

    private final IWebsiteRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public void addNewWebsite(@Valid WebsiteAddCommand command) {
        WebsiteInfoEntity entity = WebsiteFactory.from(command);
        entity.checkDomainName(repository);
        entity.checkRecorded(service);
        repository.save(entity);
    }
}
