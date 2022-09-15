package com.kisnahc.batterymanagementweb.api.infrastructure.repository;

import com.kisnahc.batterymanagementweb.api.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean existsByCompanyRegistrationNumber(String companyRegistrationNumber);

    boolean existsByTelNumber(String telNumber);
}
