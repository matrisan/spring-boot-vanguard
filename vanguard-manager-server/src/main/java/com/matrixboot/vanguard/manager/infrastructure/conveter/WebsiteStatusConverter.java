package com.matrixboot.vanguard.manager.infrastructure.conveter;

import com.matrixboot.vanguard.manager.domain.value.WebsiteStatusEnum;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * create in 2021/8/16 4:52 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SuppressWarnings("unused")
@Converter(autoApply = true)
@RequiredArgsConstructor
public class WebsiteStatusConverter implements AttributeConverter<WebsiteStatusEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(@NotNull WebsiteStatusEnum attribute) {
        return attribute.getStatus();
    }

    @Override
    public WebsiteStatusEnum convertToEntityAttribute(Integer dbData) {
        return WebsiteStatusEnum.MAP.get(dbData);
    }
}
