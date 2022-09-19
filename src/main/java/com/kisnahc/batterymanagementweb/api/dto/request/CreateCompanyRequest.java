package com.kisnahc.batterymanagementweb.api.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Data
public class CreateCompanyRequest {

    @NotBlank(message = "회사명을 입력해 주세요.")
    @Size(min = 1, max = 50)
    private String companyName;

    @NotBlank(message = "대표자명을 입력해 주세요.")
    @Size(min = 1, max = 20)
    private String companyOwner;

    @NotBlank(message = "사업자등록번호를 입력해 주세요.")
    @Pattern(regexp = "(\\d{3})-(\\d{2})-(\\d{5})", message = "사업자 등록 번호 형식을 맞춰서 입력해 주세요. ex) xxx-xx-xxxxx")
    private String companyRegistrationNumber;

    @NotBlank(message = "회사 전화번호를 입력해 주세요.")
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "전화번호 형식을 맞춰서 입력해 주세요.")
    private String telNumber;

}
