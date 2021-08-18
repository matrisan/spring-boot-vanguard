package com.matrixboot.vanguard.manager.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * create in 2021/8/16 3:04 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebsiteInfoSyncCommand {

    @NotNull
    Long id;

}
