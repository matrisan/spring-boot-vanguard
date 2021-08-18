package com.matrixboot.vanguard.manager.application;


import com.matrixboot.vanguard.manager.domain.WebsiteStatusEnum;
import com.matrixboot.vanguard.manager.domain.entity.WebsiteInfoEntity;
import com.matrixboot.vanguard.manager.interfaces.dto.WebsiteAddCommand;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

/**
 * <p>
 * create in 2021/8/16 2:50 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebsiteFactory {

    public static WebsiteInfoEntity from(@NotNull WebsiteAddCommand command) {
        return  WebsiteInfoEntity.builder()
                .domainName(command.getDomainName())
                .sourceStations(command.getSourceStation())
                .websiteStatus(WebsiteStatusEnum.JUST_ADD)
                .build();
    }

}
