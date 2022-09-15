package com.kisnahc.batterymanagementweb.api.infrastructure.repository;

import com.kisnahc.batterymanagementweb.api.domain.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {
    boolean existsByName(String name);
}
