package com.matrixboot.vanguard.manager.interfaces.facade;

import com.matrixboot.vanguard.common.ResultVO;
import com.matrixboot.vanguard.manager.application.IEngineNodeVO;
import com.matrixboot.vanguard.manager.application.service.EngineManagerService;
import com.matrixboot.vanguard.manager.domain.entity.EngineNodeEntity;
import com.matrixboot.vanguard.manager.domain.entity.WebsiteInfoEntity;
import com.matrixboot.vanguard.manager.interfaces.dto.EngineAddWebsiteCommand;
import com.matrixboot.vanguard.manager.interfaces.dto.EngineNodeCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * <p>
 * create in 2021/8/18 10:39 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
@AllArgsConstructor
public class EngineManagerFacade {

    private final EngineManagerService service;

    @GetMapping("/engines")
    public ResultVO<Page<IEngineNodeVO>> findAll(@PageableDefault Pageable pageable) {
        return new ResultVO<>(200, service.findAll(pageable));
    }

    @GetMapping("engine/websites/{id}")
    public ResultVO<Collection<WebsiteInfoEntity>> websiteInfos(@PathVariable("id") @NotNull Optional<EngineNodeEntity> entity) {
        Collection<WebsiteInfoEntity> collection = new ArrayList<>(16);
        entity.ifPresent(engineNodeEntity -> collection.addAll(engineNodeEntity.getWebsiteInfos().values()));
        return new ResultVO<>(200, collection);
    }

    @PostMapping("/engine")
    public ResultVO<String> addEngineNode(@RequestBody EngineNodeCommand command) {
        service.addEngineNode(command);
        return new ResultVO<>();
    }

    @PatchMapping("/engine")
    public ResultVO<String> addEngineNode(@RequestBody EngineAddWebsiteCommand command) {
        service.addNewWebsite(command);
        return new ResultVO<>();
    }

}
