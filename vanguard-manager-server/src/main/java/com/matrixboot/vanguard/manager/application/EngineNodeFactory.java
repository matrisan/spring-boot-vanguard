package com.matrixboot.vanguard.manager.application;

import com.matrixboot.vanguard.manager.domain.entity.EngineNodeEntity;
import com.matrixboot.vanguard.manager.interfaces.dto.EngineNodeCommand;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

/**
 * <p>
 * create in 2021/8/18 10:31 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EngineNodeFactory {

    public static EngineNodeEntity from(@NotNull EngineNodeCommand command) {
        return EngineNodeEntity.builder()
                .nodeName(command.getNodeName())
                .nodeCode(command.getNodeCode())
                .engineNodes(command.getEngineNodes())
                .build();
    }

}
