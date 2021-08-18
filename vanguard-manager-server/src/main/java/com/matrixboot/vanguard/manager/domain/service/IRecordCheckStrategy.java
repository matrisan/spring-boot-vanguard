package com.matrixboot.vanguard.manager.domain.service;

/**
 * <p>
 * create in 2021/8/16 2:43 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@FunctionalInterface
public interface IRecordCheckStrategy {

    /**
     * 判断是否备案
     *
     * @param domain 域名
     * @return boolean
     */
    boolean isRecord(String domain);

}


