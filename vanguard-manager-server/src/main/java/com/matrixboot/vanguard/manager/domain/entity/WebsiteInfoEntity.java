package com.matrixboot.vanguard.manager.domain.entity;


import cn.hutool.crypto.SecureUtil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.matrixboot.vanguard.manager.domain.repository.IWebsiteRepository;
import com.matrixboot.vanguard.manager.domain.service.IRecordCheckStrategy;
import com.matrixboot.vanguard.manager.domain.value.WebsiteStatusEnum;
import com.matrixboot.vanguard.manager.infrastructure.conveter.ListConverter;
import com.matrixboot.vanguard.manager.infrastructure.exception.WebsiteDomainNameExistedException;
import com.matrixboot.vanguard.manager.infrastructure.exception.WebsiteNotRecordedException;
import com.matrixboot.vanguard.manager.interfaces.dto.WebsiteInfoSyncCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * create in 2021/8/16 2:41 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SuppressWarnings("unused")
@Slf4j
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
public class WebsiteInfoEntity implements IWebsiteInfo, Serializable {

    private static final long serialVersionUID = -5116915243005098872L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 域名
     */
    @Column(name = "domain_name", nullable = false, columnDefinition = "VARCHAR(20) COMMENT 'domainName'")
    private String domainName;

    /**
     * 源站的地址
     */
    @Convert(converter = ListConverter.class)
    @Column(name = "source_stations", nullable = false, columnDefinition = "VARCHAR(20) COMMENT 'sourceStations'")
    private List<String> sourceStations;

    /**
     * 网站状态
     */
    @Column(name = "website_status", nullable = false, columnDefinition = "VARCHAR(20) COMMENT 'websiteStatus'")
    private WebsiteStatusEnum websiteStatus;

    /**
     * 引擎节点
     */
    @ToString.Exclude
    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "websiteInfos")
    private List<EngineNodeEntity> engineNodes;

    /**
     * 检查是否备案
     *
     * @return boolean
     */
    public boolean isRecorded(@NotNull IRecordCheckStrategy service) {
        return service.isRecord(this.domainName);
    }

    /**
     * 当前对象 MD5
     *
     * @return String
     */
    public String getMd5() {
        return SecureUtil.md5(toString());
    }

    /**
     * 网站创建成功事件
     *
     * @return WebsiteInfoSyncCommand
     */
    @DomainEvents
    public WebsiteInfoSyncCommand domainEvents() {
        log.info("domainEvents");
        return WebsiteInfoSyncCommand.builder().id(id).build();
    }

    @AfterDomainEventPublication
    public void callbackMethod() {
        log.info("AfterDomainEventPublication");
    }

    public void checkDomainName(@NotNull IWebsiteRepository repository) {
        if (repository.existsByDomainName(getDomainName())) {
            throw new WebsiteDomainNameExistedException("网站已经存在!");
        }
    }

    public void checkRecorded(@NotNull IRecordCheckStrategy service) {
        if (!service.isRecord(getDomainName())) {
            throw new WebsiteNotRecordedException("网站未备案!");
        }
    }
}
