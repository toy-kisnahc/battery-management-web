package com.kisnahc.batterymanagementweb.api.service;

import com.kisnahc.batterymanagementweb.api.domain.Battery;
import com.kisnahc.batterymanagementweb.api.domain.BatteryType;
import com.kisnahc.batterymanagementweb.api.domain.Manufacturer;
import com.kisnahc.batterymanagementweb.api.dto.request.CreateBatteryRequest;
import com.kisnahc.batterymanagementweb.api.infrastructure.repository.BatteryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BatteryServiceImplTest {

    @Autowired
    private BatteryRepository batteryRepository;

    @Test
    void success_create_batter_test() {

        CreateBatteryRequest createBatteryRequest = getCreateBatteryRequest();

        Battery battery = Battery.builder()
                .name(createBatteryRequest.getBatteryName())
                .type(createBatteryRequest.getType())
                .voltage(createBatteryRequest.getVoltage())
                .price(createBatteryRequest.getPrice())
                .build();

        Battery saveBattery = batteryRepository.save(battery);

        Assertions.assertThat(saveBattery.getId()).isEqualTo(battery.getId());
        Assertions.assertThat(saveBattery.getName()).isEqualTo(battery.getName());
        Assertions.assertThat((long) batteryRepository.findAll().size()).isEqualTo(1L);
    }

    private static CreateBatteryRequest getCreateBatteryRequest() {
        return new CreateBatteryRequest("BatteryA", BatteryType.CELL, Manufacturer.ROCKET, "1.5V", 1000);
    }
}