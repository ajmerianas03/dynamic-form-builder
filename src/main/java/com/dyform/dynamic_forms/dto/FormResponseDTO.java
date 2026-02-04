package com.dyform.dynamic_forms.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class FormResponseDTO {
    private UUID formId;
    private String formName;
    private Boolean isPaymentEnabled;
    private BigDecimal paymentAmount;
    private String currency;
    private String status;
    private List<FormFieldDTO> fields;
}
