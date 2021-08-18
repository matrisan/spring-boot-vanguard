package com.matrixboot.vanguard.manager.domain.service;

import com.matrixboot.vanguard.manager.domain.entity.IWebsiteInfo;
import com.matrixboot.vanguard.manager.infrastructure.ext.release.Release;

/**
 * create in 2021/8/18 2:33 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface INodeReleaseConverter {

    /**
     * 转换成节点数据
     *
     * @param entity 实体类
     * @return Object
     */
    Release convert(IWebsiteInfo entity);

}
