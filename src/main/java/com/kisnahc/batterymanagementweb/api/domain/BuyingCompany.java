package com.kisnahc.batterymanagementweb.api.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class BuyingCompany extends BaseTimeEntity {

    @Column(name = "buying_company_id")
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Pattern(regexp = "/([0-9]{3})-?([0-9]{2})-?([0-9]{5})/")
    @Column(nullable = false)
    private String companyRegistrationNumber;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$")
    @Column(nullable = false)
    private String telNumber;

    @OneToMany(mappedBy = "buyingCompany", cascade = CascadeType.ALL)
    private List<Battery> batteries = new ArrayList<>();

}
