package com.matrixboot.vanguard.manager.domain.service;

/**
 * 远程同步策略
 *
 * <p>
 * create in 2021/8/18 3:00 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@FunctionalInterface
public interface IRemoteSyncStrategy {

    /**
     * 开始同步
     *
     * @param data 要同步的数据
     */
    void startSync(Object data);
}
