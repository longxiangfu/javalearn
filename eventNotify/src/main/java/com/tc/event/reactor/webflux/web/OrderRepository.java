package com.tc.event.reactor.webflux.web;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor {

    Order findAllByMemberId(Long memberId);

    @Transactional
    @Modifying
    @Query("update Order o set o.status =:status where o.id =:id")
    void updateStatusById(@Param("status") Integer status, @Param("id") Long id);

    Order getById(Long id);

    @Query("select o from Order o where o.id in :idList")
    List<Order> getListByIdList(@Param("idList") List idList);

}