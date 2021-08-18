package com.matrixboot.vanguard.manager.interfaces.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * <p>
 * create in 2021/8/18 10:30 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
public class EngineNodeCommand {

    @NotBlank
    private String nodeName;

    @NotBlank
    private String nodestatus;

    @Size(min = 1, max = 10)
    List<String> engineNodes;

}
