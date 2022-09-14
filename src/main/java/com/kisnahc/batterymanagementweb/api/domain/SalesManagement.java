package com.kisnahc.batterymanagementweb.api.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class SalesManagement {

    @Column(name = "sales_management_id")
    @Id @GeneratedValue
    private Long id;

    private LocalDateTime salesDate;

    @OneToMany
    private List<Battery> batteries;

    private int quantity;

    private int price;


}
