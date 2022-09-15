package com.kisnahc.batterymanagementweb.api.domain;

import com.kisnahc.batterymanagementweb.api.dto.request.UpdateBatteryRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Battery extends BaseTimeEntity{

    @Column(name = "battery_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String voltage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BatteryType type;

    @Column(nullable = false)
    private int price;


    @Builder
    public Battery(Long id, String name, String voltage, BatteryType type, int price) {
        this.id = id;
        this.name = name;
        this.voltage = voltage;
        this.type = type;
        this.price = price;
    }

    /*
        수정 메서드
     */
    public void updateCompany(UpdateBatteryRequest request) {
        this.name = request.getBatteryName();
        this.voltage = request.getVoltage();
        this.type = request.getType();
        this.price = request.getPrice();
    }


}
