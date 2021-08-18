package com.matrixboot.vanguard.manager.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * create in 2021/8/16 4:25 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Getter
public enum WebsiteStatusEnum {

    JUST_ADD(0, "网站已经添加"),

    CONFIG_SYNCHRONIZED(1, "网站配置已经同步");

    public static final Map<Integer, WebsiteStatusEnum> MAP = Arrays.stream(WebsiteStatusEnum.values())
            .collect(Collectors.toMap(x -> x.status, x -> x));

    private final Integer status;

    private final String message;


    WebsiteStatusEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


}
