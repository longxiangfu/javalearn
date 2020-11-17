package com.ct.multidatasource.jpa.first.repository;

import com.ct.multidatasource.jpa.first.domain.PrimaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimaryRepository extends JpaRepository<PrimaryEntity, Long> {
    @Query(value = "SELECT p FROM PrimaryEntity p  where p.id < 1000100")
    List<PrimaryEntity> queryList();
}
