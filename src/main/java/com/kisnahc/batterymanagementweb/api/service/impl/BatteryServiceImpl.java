package com.kisnahc.batterymanagementweb.api.service.impl;

import com.kisnahc.batterymanagementweb.api.domain.Battery;
import com.kisnahc.batterymanagementweb.api.dto.request.CreateBatteryRequest;
import com.kisnahc.batterymanagementweb.api.dto.request.UpdateBatteryRequest;
import com.kisnahc.batterymanagementweb.api.dto.response.*;
import com.kisnahc.batterymanagementweb.api.dto.response.create.CreateBatteryResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.delete.DeleteBatteryResponse;
import com.kisnahc.batterymanagementweb.api.dto.response.update.UpdateBatteryResponse;
import com.kisnahc.batterymanagementweb.api.exception.BatteryDuplicateException;
import com.kisnahc.batterymanagementweb.api.exception.BatteryNotFoundException;
import com.kisnahc.batterymanagementweb.api.infrastructure.repository.BatteryRepository;
import com.kisnahc.batterymanagementweb.api.service.BatteryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static javax.servlet.http.HttpServletResponse.SC_CREATED;
import static javax.servlet.http.HttpServletResponse.SC_OK;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BatteryServiceImpl implements BatteryService {

    private final BatteryRepository batteryRepository;

    /**
     * 배터리 등록.
     * @param request
     * @return
     */
    @Transactional
    @Override
    public ApiResponse<CreateBatteryResponse> create(CreateBatteryRequest request) {

        Battery battery = Battery.builder()
                .name(request.getBatteryName())
                .voltage(request.getVoltage())
                .type(request.getType())
                .manufacturer(request.getManufacturer())
                .price(request.getPrice())
                .build();

        duplicateValidate(battery.getName());

        Battery saveBattery = batteryRepository.save(battery);

        return new ApiResponse<>(SC_CREATED, new CreateBatteryResponse(saveBattery));
    }

    /**
     * 배터리 조회.
     * @param batteryId
     * @return
     */
    @Override
    public ApiResponse<BatteryResponse> get(Long batteryId) {

        Battery battery = batteryRepository.findById(batteryId)
                .orElseThrow(BatteryNotFoundException::new);

        return new ApiResponse<>(SC_OK, new BatteryResponse(battery));
    }

    /**
     * 배터리 전체 조회.
     * @return
     */
    @Override
    public ApiResponse<List<BatteryResponse>> getAll() {

        List<Battery> batteries = batteryRepository.findAll();

        List<BatteryResponse> batteryResponses = batteries.stream()
                .map(BatteryResponse::new)
                .collect(Collectors.toList());

        return new ApiResponse<>(SC_OK, batteryResponses.size() , batteryResponses);
    }

    /**
     * 배터리 수정.
     * @param batteryId
     * @param request
     * @return
     */
    @Transactional
    @Override
    public ApiResponse<UpdateBatteryResponse> update(Long batteryId, UpdateBatteryRequest request) {

        Battery battery = batteryRepository.findById(batteryId)
                .orElseThrow(BatteryNotFoundException::new);

        duplicateValidate(request.getBatteryName());

        battery.updateCompany(request);

        return new ApiResponse<>(SC_OK, new UpdateBatteryResponse(battery));
    }

    /**
     * 배터리 삭제.
     * @param batteryId
     * @return
     */
    @Transactional
    @Override
    public ApiResponse<DeleteBatteryResponse> delete(Long batteryId) {
        Battery battery = batteryRepository.findById(batteryId)
                .orElseThrow(BatteryNotFoundException::new);

        batteryRepository.delete(battery);

        return new ApiResponse<>(SC_OK, new DeleteBatteryResponse(battery));
    }

    private void duplicateValidate(String name) {
        if (batteryRepository.existsByName(name)) {
            throw new BatteryDuplicateException("이미 등록된 제품명 입니다.");
        }
    }
}
