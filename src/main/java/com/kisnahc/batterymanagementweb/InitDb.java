//package com.kisnahc.batterymanagementweb;
//
//import com.kisnahc.batterymanagementweb.api.domain.*;
//import com.kisnahc.batterymanagementweb.api.infrastructure.repository.BatteryRepository;
//import com.kisnahc.batterymanagementweb.api.infrastructure.repository.CompanyRepository;
//import com.kisnahc.batterymanagementweb.api.infrastructure.repository.SalesRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//
//@Component
//@RequiredArgsConstructor
//public class InitDb {
//    private final InitService initService;
//
//    @PostConstruct
//    public void init() {
//        initService.dbInit();
//    }
//
//    @Slf4j
//    @Component
//    @Transactional
//    @RequiredArgsConstructor
//    static class InitService {
//
//        private final CompanyRepository companyRepository;
//        private final BatteryRepository batteryRepository;
//        private final SalesRepository salesRepository;
//
//        public void dbInit() {
//
//            // 회사 등록.
//            Company companyA = Company.builder()
//                    .name("CompanyA")
//                    .companyRegistrationNumber("111-11-11111")
//                    .telNumber("11-111-1111")
//                    .build();
//            companyRepository.save(companyA);
//
//            // 배터리 등록.
//            Battery batteryA = Battery.builder()
//                    .name("BatteryA")
//                    .voltage("2.0V")
//                    .type(BatteryType.CELL)
//                    .price(10000)
//                    .build();
//            batteryRepository.save(batteryA);
//
//            Battery batteryB = Battery.builder()
//                    .name("BatteryB")
//                    .voltage("2.0V")
//                    .type(BatteryType.MODULE)
//                    .price(20000)
//                    .build();
//            batteryRepository.save(batteryB);
//
//            Battery batteryC = Battery.builder()
//                    .name("BatteryC")
//                    .voltage("2.0V")
//                    .type(BatteryType.PACK)
//                    .price(30000)
//                    .build();
//            batteryRepository.save(batteryC);
//
//            OrderBattery orderBatteryA = OrderBattery.createOrder(batteryA, batteryA.getPrice(), 3);
//            OrderBattery orderBatteryB = OrderBattery.createOrder(batteryA, batteryA.getPrice(), 1);
//            OrderBattery orderBatteryC = OrderBattery.createOrder(batteryA, batteryA.getPrice(), 2);
//
//            log.info("회사 = {}", companyA.getName());
//            Sales salesA = Sales.createSales(companyA, orderBatteryA, orderBatteryB);
//            log.info("매출 회사 = {}", salesA.getCompany().getName());
//
//            salesRepository.save(salesA);
//            salesRepository.save(Sales.createSales(companyA, orderBatteryC));
//
//        }
//    }
//
//}
//
//
