package com.kisnahc.batterymanagementweb.api.domain;

import com.kisnahc.batterymanagementweb.api.dto.request.UpdateCompanyRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Company extends BaseTimeEntity {

    @Column(name = "company_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false, unique = true)
    private String companyRegistrationNumber;


    @Column(nullable = false, unique = true)
    private String telNumber;

    @OneToMany(mappedBy = "company")
    private List<Sales> salesList = new ArrayList<>();

    @Builder
    public Company(String name, String owner, String companyRegistrationNumber, String telNumber, List<Sales> salesList) {
        this.name = name;
        this.owner = owner;
        this.companyRegistrationNumber = companyRegistrationNumber;
        this.telNumber = telNumber;
        this.salesList = salesList;
    }

    public void updateCompany(UpdateCompanyRequest request) {
        this.name = request.getCompanyName();
        this.owner =
        this.companyRegistrationNumber = request.getCompanyRegistrationNumber();
        this.telNumber = request.getTelNumber();
    }
}
