package com.matrixboot.vanguard.manager.interfaces.facade;

import com.matrixboot.vanguard.common.ResultVO;
import com.matrixboot.vanguard.manager.application.IEngineNodeVO;
import com.matrixboot.vanguard.manager.application.service.EngineNodeManagerService;
import com.matrixboot.vanguard.manager.interfaces.dto.EngineNodeCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class EngineNodeManagerFacade {

    private final EngineNodeManagerService service;

    @GetMapping("/engines")
    public ResultVO<Page<IEngineNodeVO>> findAll(@PageableDefault Pageable pageable) {
//        return new ResultVO<>(200, service.findAll(pageable));
        return new ResultVO<>();
    }

    @GetMapping("/test")
    public ResultVO<String> findAll() {
//        return new ResultVO<>(200, service.findAll(pageable));
        return new ResultVO<>();
    }


    @PostMapping("/engine")
    public ResultVO<String> addEngineNode(EngineNodeCommand command) {
        service.addEngineNode(command);
        return new ResultVO<>();
    }
}
