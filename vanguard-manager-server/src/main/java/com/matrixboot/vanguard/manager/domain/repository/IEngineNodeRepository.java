package com.matrixboot.vanguard.manager.domain.repository;


import com.matrixboot.vanguard.manager.domain.entity.EngineNodeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * create in 2021/8/16 3:12 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IEngineNodeRepository extends JpaRepository<EngineNodeEntity, Long> {

    /**
     * 查找所有的节点信息
     *
     * @param pageable 分页信息
     * @param clx      泛型
     * @param <T>      类型
     * @return page
     */
    <T> Page<T> findAllBy(Pageable pageable, Class<T> clx);

}
