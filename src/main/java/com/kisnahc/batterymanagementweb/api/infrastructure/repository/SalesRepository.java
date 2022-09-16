package com.kisnahc.batterymanagementweb.api.infrastructure.repository;

import com.kisnahc.batterymanagementweb.api.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
}
