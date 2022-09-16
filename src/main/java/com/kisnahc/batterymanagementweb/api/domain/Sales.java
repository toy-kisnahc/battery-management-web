package com.kisnahc.batterymanagementweb.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Sales extends BaseTimeEntity {

    @Column(name = "sales_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL)
    private List<OrderBattery> orderBatteries = new ArrayList<>();

    // TODO
    private LocalDateTime salesDate;

    /*
            매출 생성 메서드.
         */
    public static Sales createSales(Company company, OrderBattery... orderBatteries) {
        Sales sales = new Sales();
        sales.setCompany(company);

        for (OrderBattery orderBattery : orderBatteries) {
            sales.addOrderBattery(orderBattery);
        }
        return sales;
    }

    /*
        매출 수정 메서드.
     */

    /*
            매출 가격 조회 메서드.
         */
    public int getTotalPrice() {
        return orderBatteries.stream()
                .mapToInt(OrderBattery::getTotalPrice)
                .sum();
    }

    //== 연관관계 편의 메서드 ==//
    public void setCompany(Company company) {
        this.company = company;
        company.getSalesList().add(this);
    }

    public void addOrderBattery(OrderBattery orderBattery) {
        orderBatteries.add(orderBattery);
        orderBattery.setSales(this);
    }

}
