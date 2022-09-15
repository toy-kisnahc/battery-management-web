package com.kisnahc.batterymanagementweb.api.domain;

import javax.persistence.*;

@Entity
public class SalesBattery extends BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "sales_battery_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "battery_id")
    private Battery battery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_id")
    private Sales sales;

    @Column(nullable = false)
    private int count;

    @Column(nullable = false)
    private int totalPrice;
}
