package com.matrixboot.vanguard.manager.domain.repository;


import com.matrixboot.vanguard.manager.domain.entity.WebsiteInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * <p>
 * create in 2021/8/16 2:53 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IWebsiteRepository extends JpaRepository<WebsiteInfoEntity, Long> {

    boolean existsByDomainName(String domainName);

    <T> Optional<T> findById(long id, Class<T> clx);

}
