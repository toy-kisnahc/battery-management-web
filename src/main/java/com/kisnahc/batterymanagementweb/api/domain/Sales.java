package com.kisnahc.batterymanagementweb.api.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Sales extends BaseTimeEntity{

    @Column(name = "sales_id")
    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL)
    private List<SalesBattery> salesBatteries = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime salesDate;

    @Column(nullable = false)
    private int salesPrice;


}
