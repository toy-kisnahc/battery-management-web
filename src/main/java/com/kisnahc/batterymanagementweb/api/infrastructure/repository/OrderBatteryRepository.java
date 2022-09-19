package com.kisnahc.batterymanagementweb.api.infrastructure.repository;

import com.kisnahc.batterymanagementweb.api.domain.OrderBattery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBatteryRepository extends JpaRepository<OrderBattery, Long> {
}
