package com.matrixboot.vanguard.manager.infrastructure.ext.release;

import com.matrixboot.vanguard.manager.domain.entity.IWebsiteInfo;
import com.matrixboot.vanguard.manager.domain.service.INodeReleaseConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * create in 2021/8/18 2:36 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Service("ConverterReleaseV1")
public class NodeReleaseV1Converter implements INodeReleaseConverter {

    @Override
    public Release convert(IWebsiteInfo entity) {
        return new ReleaseV1();
    }

}
