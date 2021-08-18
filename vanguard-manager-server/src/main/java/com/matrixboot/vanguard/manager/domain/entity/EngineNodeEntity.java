package com.matrixboot.vanguard.manager.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.matrixboot.vanguard.manager.infrastructure.conveter.ListConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.OrderBy;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.ID;

/**
 * <p>
 * create in 2021/8/16 3:10 下午
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
public class EngineNodeEntity implements Serializable {

    private static final long serialVersionUID = -7702300799053897495L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "node_name", nullable = false, columnDefinition = "VARCHAR(20) COMMENT 'node name'")
    private String nodeName;

    @Column(name = "node_status", nullable = false, columnDefinition = "VARCHAR(20) COMMENT 'node status'")
    private String nodestatus;

    /**
     * 引擎的地址
     */
    @Convert(converter = ListConverter.class)
    @Column(name = "engine_nodes", nullable = false, columnDefinition = "VARCHAR(20) COMMENT 'engine nodes'")
    private List<String> engineNodes;

    /**
     * 引擎上的网站
     */
    @MapKey
    @OrderBy("id ASC")
    @ToString.Exclude
    @JsonManagedReference
    @ManyToMany(targetEntity = WebsiteInfoEntity.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "many_to_many_role_user",
            joinColumns = @JoinColumn(name = "mid_node_id", referencedColumnName = ID),
            inverseJoinColumns = @JoinColumn(name = "mid_website_id", referencedColumnName = ID),
            indexes = {@Index(columnList = "mid_node_id,mid_website_id", name = "uk_node_website", unique = true)}
    )
    private Map<Long, WebsiteInfoEntity> websiteInfos;

    /**
     * 新增网站信息
     *
     * @param entity 网站信息
     */
    public void addWebsiteInfo(WebsiteInfoEntity entity) {
        websiteInfos.put(entity.getId(), entity);
    }
}
