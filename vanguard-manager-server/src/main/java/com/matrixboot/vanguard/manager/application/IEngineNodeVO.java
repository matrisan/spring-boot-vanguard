package com.matrixboot.vanguard.manager.application;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * create in 2021/8/17 4:45 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IEngineNodeVO extends Serializable {

    /**
     * id
     *
     * @return long
     */
    Long getId();

    /**
     * Nodes
     *
     * @return list
     */
    List<String> getEngineNodes();

}
