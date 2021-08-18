package com.matrixboot.vanguard.manager.infrastructure.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * create in 2021/8/16 5:45 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class WebsiteDomainNameExistedException extends AbstractWebsiteInfoException {

    private static final long serialVersionUID = -4787369597300694837L;

    @Getter
    private final String message;

    public WebsiteDomainNameExistedException(String message) {
        this.message = message;
    }
}
