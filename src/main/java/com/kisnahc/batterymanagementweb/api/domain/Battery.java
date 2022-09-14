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
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String voltage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BatteryType type;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buying_company_id")
    private BuyingCompany buyingCompany;


    @Builder
    public Battery(Long id, String name, String voltage, BatteryType type, int quantity, int price, BuyingCompany buyingCompany) {
        this.id = id;
        this.name = name;
        this.voltage = voltage;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.buyingCompany = buyingCompany;
    }

    /*
        수정 메서드
     */
    public void update(UpdateBatteryRequest request) {
        this.quantity =request.getQuantity();
        this.price = request.getPrice();
    }
}
