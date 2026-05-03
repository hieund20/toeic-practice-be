package com.toeic.demo.repository;

import com.toeic.demo.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TestRepository extends JpaRepository<Test, UUID> {

    @Query("""
    SELECT DISTINCT t
    FROM Test t
    LEFT JOIN FETCH t.parts p
    LEFT JOIN FETCH p.questions q
    LEFT JOIN FETCH p.groups g
    WHERE t.id = :id
    ORDER BY p.partNumber, q.questionOrder
    """)
    Optional<Test> findWithFullStructureById(UUID id);
}
