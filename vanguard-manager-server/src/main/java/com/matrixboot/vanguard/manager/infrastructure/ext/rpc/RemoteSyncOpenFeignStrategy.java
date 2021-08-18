package com.matrixboot.vanguard.manager.infrastructure.ext.rpc;

import com.matrixboot.vanguard.manager.domain.service.IRemoteSyncStrategy;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

/**
 * <p>
 * create in 2021/8/18 3:51 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Service("RemoteReleaseV1")
public class RemoteSyncOpenFeignStrategy implements IRemoteSyncStrategy {

    @Override
    public void startSync(@NotNull Object data) {
        System.out.println(data);
    }
}
