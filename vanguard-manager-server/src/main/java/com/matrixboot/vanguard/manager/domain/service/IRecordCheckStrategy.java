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

    boolean isRecord(String domain);

}


