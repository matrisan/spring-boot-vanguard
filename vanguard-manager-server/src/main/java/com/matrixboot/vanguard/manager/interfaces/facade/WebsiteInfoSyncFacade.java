package com.matrixboot.vanguard.manager.interfaces.facade;

import com.matrixboot.vanguard.common.ResultVO;
import com.matrixboot.vanguard.manager.application.service.WebsiteInfoSyncService;
import com.matrixboot.vanguard.manager.interfaces.dto.WebsiteInfoSyncCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * create in 2021/8/16 3:39 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@RestController
@AllArgsConstructor
public class WebsiteInfoSyncFacade {

    private final WebsiteInfoSyncService service;

    /**
     * 自动同步
     *
     * @param command 同步 Command
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void autoSync(@NotNull WebsiteInfoSyncCommand command) {
        service.websiteInfoSync(command);
    }

    /**
     * 手动同步
     *
     * @param command 同步 Command
     * @return ResultVO
     */
    @PostMapping("sync")
    public ResultVO<String> manualSync(@RequestBody WebsiteInfoSyncCommand command) {
        service.websiteInfoSync(command);
        return new ResultVO<>();
    }
}
