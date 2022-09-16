package com.kisnahc.batterymanagementweb.api.service.impl;

import com.kisnahc.batterymanagementweb.api.domain.Battery;
import com.kisnahc.batterymanagementweb.api.domain.Company;
import com.kisnahc.batterymanagementweb.api.domain.OrderBattery;
import com.kisnahc.batterymanagementweb.api.domain.Sales;
import com.kisnahc.batterymanagementweb.api.dto.response.ApiResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.DeleteSalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateSalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.SalesResponse;
import com.kisnahc.batterymanagementweb.api.exception.BatteryNotFoundException;
import com.kisnahc.batterymanagementweb.api.exception.CompanyNotFoundException;
import com.kisnahc.batterymanagementweb.api.exception.SalesNotFoundException;
import com.kisnahc.batterymanagementweb.api.infrastructure.repository.BatteryRepository;
import com.kisnahc.batterymanagementweb.api.infrastructure.repository.CompanyRepository;
import com.kisnahc.batterymanagementweb.api.infrastructure.repository.SalesRepository;
import com.kisnahc.batterymanagementweb.api.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static javax.servlet.http.HttpServletResponse.SC_CREATED;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;
    private final CompanyRepository companyRepository;
    private final BatteryRepository batteryRepository;

    @Transactional
    @Override
    public ApiResponse<CreateSalesResponse> create(Long companyId, Long batteryId, int count) {
        Company company = companyRepository.findById(companyId).orElseThrow(CompanyNotFoundException::new);
        Battery battery = batteryRepository.findById(batteryId).orElseThrow(BatteryNotFoundException::new);

        // 주문 생성.
        OrderBattery orderBattery = OrderBattery.createOrder(battery, battery.getPrice(), count);

        // 매출 등록.
        Sales sales = Sales.createSales(company, orderBattery);

        Sales saveSales = salesRepository.save(sales);

        return new ApiResponse<>(SC_CREATED, new CreateSalesResponse(saveSales));

    }

    @Override
    public ApiResponse<SalesResponse> get(Long salesId) {
        Sales sales = salesRepository.findById(salesId).orElseThrow(SalesNotFoundException::new);

        //TODO
//        sales.updateOrderBattery();
        return new ApiResponse<>(SC_OK, new SalesResponse(sales));
    }

    @Override
    public ApiResponse<List<SalesResponse>> getAll() {
        List<Sales> salesList = salesRepository.findAll();

        List<SalesResponse> salesResponses = salesList.stream()
                .map(SalesResponse::new)
                .collect(Collectors.toList());

        return new ApiResponse<>(SC_OK, salesResponses.size(), salesResponses);
    }

    @Transactional
    @Override
    public ApiResponse<?> update(Long salesId) {
        return null;
    }

    @Transactional
    @Override
    public ApiResponse<DeleteSalesResponse> delete(Long salesId) {
        Sales sales = salesRepository.findById(salesId).orElseThrow(SalesNotFoundException::new);

        salesRepository.delete(sales);

        return new ApiResponse<>(SC_OK, new DeleteSalesResponse(sales));
    }
}
