package com.github.furistao.covid19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.github.furistao.covid19.model.Covid19Case;

@Repository
public interface Covid19CaseRepository extends JpaRepository<Covid19Case, Long> {

        @Query(value = "SELECT c.id, c.name, c.gender, c.age, c.address, c.city, c.country, c.status, c.created_at, c.updated_at FROM covid_19_case c ORDER BY c.id DESC LIMIT 1", nativeQuery = true)
        Covid19Case getMaxIdCase();

        @Query(value = "SELECT c.id, c.name, c.gender, c.age, c.address, c.city, c.country, c.status, c.created_at, c.updated_at FROM covid_19_case c WHERE c.updated_at BETWEEN :from AND :to ORDER BY c.updated_at ASC", nativeQuery = true)
        List<Covid19Case> findByUpdatedAtBetween(@Param("from") String from, @Param("to") String to);
}
