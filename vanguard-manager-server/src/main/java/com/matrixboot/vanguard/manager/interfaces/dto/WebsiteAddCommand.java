package com.matrixboot.vanguard.manager.interfaces.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 * create in 2021/8/16 2:49 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Data
public class WebsiteAddCommand {

    @NotBlank
    String domainName;

    List<String> sourceStation;


}
