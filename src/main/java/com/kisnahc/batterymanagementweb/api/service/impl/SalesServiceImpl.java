package com.kisnahc.batterymanagementweb.api.service.impl;

import com.kisnahc.batterymanagementweb.api.domain.Battery;
import com.kisnahc.batterymanagementweb.api.domain.Company;
import com.kisnahc.batterymanagementweb.api.domain.OrderBattery;
import com.kisnahc.batterymanagementweb.api.domain.Sales;
import com.kisnahc.batterymanagementweb.api.dto.request.CreateSalesRequest;
import com.kisnahc.batterymanagementweb.api.dto.request.UpdateOrderBatteryRequest;
import com.kisnahc.batterymanagementweb.api.dto.response.ApiResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.delete.DeleteSalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.update.UpdateSalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateSalesResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.SalesResponse;
import com.kisnahc.batterymanagementweb.api.exception.BatteryNotFoundException;
import com.kisnahc.batterymanagementweb.api.exception.CompanyNotFoundException;
import com.kisnahc.batterymanagementweb.api.exception.OrderBatteryNotFoundException;
import com.kisnahc.batterymanagementweb.api.exception.SalesNotFoundException;
import com.kisnahc.batterymanagementweb.api.infrastructure.repository.BatteryRepository;
import com.kisnahc.batterymanagementweb.api.infrastructure.repository.CompanyRepository;
import com.kisnahc.batterymanagementweb.api.infrastructure.repository.OrderBatteryRepository;
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
    private final OrderBatteryRepository orderBatteryRepository;

    @Transactional
    @Override
    public ApiResponse<CreateSalesResponse> create(CreateSalesRequest request) {
        Company company = companyRepository.findById(request.getCompanyId()).orElseThrow(CompanyNotFoundException::new);
        Battery battery = batteryRepository.findById(request.getBatteryId()).orElseThrow(BatteryNotFoundException::new);

        // 주문 생성.
        OrderBattery orderBattery = OrderBattery.createOrder(battery, battery.getPrice(), request.getCount());

        // 매출 등록.
        Sales sales = Sales.createSales(company, orderBattery);

        Sales saveSales = salesRepository.save(sales);

        return new ApiResponse<>(SC_CREATED, new CreateSalesResponse(saveSales));

    }

    @Override
    public ApiResponse<SalesResponse> get(Long salesId) {
        Sales sales = salesRepository.findById(salesId).orElseThrow(SalesNotFoundException::new);
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

    /*
        주문 수량 수정.
     */
    @Transactional
    @Override
    public ApiResponse<UpdateSalesResponse> update(Long salesId, UpdateOrderBatteryRequest request) {
        OrderBattery orderBattery = orderBatteryRepository.findById(request.getOrderBatteryId()).orElseThrow(OrderBatteryNotFoundException::new);
        Sales sales = salesRepository.findById(salesId).orElseThrow(OrderBatteryNotFoundException::new);
        orderBattery.updateOrder(request);
        return new ApiResponse<>(SC_OK, new UpdateSalesResponse(sales, request));
    }

    @Transactional
    @Override
    public ApiResponse<DeleteSalesResponse> delete(Long salesId) {
        Sales sales = salesRepository.findById(salesId).orElseThrow(SalesNotFoundException::new);

        salesRepository.delete(sales);

        return new ApiResponse<>(SC_OK, new DeleteSalesResponse(sales));
    }
}
