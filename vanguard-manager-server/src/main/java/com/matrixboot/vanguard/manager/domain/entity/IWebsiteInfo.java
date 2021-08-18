package com.matrixboot.vanguard.manager.domain.entity;

import com.matrixboot.vanguard.manager.domain.value.WebsiteStatusEnum;

import java.util.List;

/**
 * <p>
 * create in 2021/8/18 3:05 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IWebsiteInfo {

    Long getId();

    String getDomainName();

    List<String> getSourceStations();

    WebsiteStatusEnum getWebsiteStatus();

}
