package com.kisnahc.batterymanagementweb.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "orders_battery")
@Entity
public class OrderBattery extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_battery_id")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "battery_id")
    private Battery battery;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_id")
    private Sales sales;

    @Column(nullable = false)
    private int orderCount; // 주문수량.

    @Column(nullable = false)
    private int orderPrice; // 주문가격.

    //== 연관관계 편의 메서드 ==//
    public void setSales(Sales sales) {
        this.sales = sales;
    }

    @Builder
    public OrderBattery(Long id, Battery battery, Sales sales, int orderCount, int orderPrice) {
        this.id = id;
        this.battery = battery;
        this.sales = sales;
        this.orderCount = orderCount;
        this.orderPrice = orderPrice;
    }

    /*
        주문 생성 메서드.
     */
    public static OrderBattery createOrder(Battery battery, int orderPrice, int orderCount) {
        return OrderBattery.builder()
                .battery(battery)
                .orderCount(orderCount)
                .orderPrice(orderPrice)
                .build();
    }

    /*
        주문 합계 금액.
     */
    public int getTotalPrice() {
        return getOrderCount() * getOrderPrice();
    }
}
