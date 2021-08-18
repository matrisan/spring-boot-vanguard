package com.matrixboot.vanguard.manager.interfaces.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * create in 2021/8/18 2:07 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Data
public class EngineAddWebsiteCommand {

    private Long nodeId;

    private Long websiteId;

}
