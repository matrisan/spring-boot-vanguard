package com.matrixboot.vanguard.agent.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * create in 2021/8/18 10:05 上午
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
//@DynamicInsert
//@DynamicUpdate
//@Entity
public class DockerImageEntity {

    private String release;

    private String dockerfile;



}
