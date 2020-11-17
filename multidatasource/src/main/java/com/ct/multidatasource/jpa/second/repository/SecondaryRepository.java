package com.ct.multidatasource.jpa.second.repository;

import com.ct.multidatasource.jpa.second.domain.SecondaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondaryRepository extends JpaRepository<SecondaryEntity, Long> {

    @Query(value = "SELECT p FROM SecondaryEntity p where id < 1000060")
    List<SecondaryEntity> queryList();

}
