package com.manpur.minute_bazar.repository;

import com.manpur.minute_bazar.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Long> {
}
