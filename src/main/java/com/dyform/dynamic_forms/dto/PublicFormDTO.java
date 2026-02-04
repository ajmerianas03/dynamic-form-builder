package com.dyform.dynamic_forms.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class PublicFormDTO {
    private UUID formId;
    private String formName;
    private Boolean isPaymentEnabled;

    private List<FormFieldDTO> fieldDTOS;
}
