package com.dyform.dynamic_forms.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class FormRequestDTO {

   @NotNull
    private String formName;

   private Boolean isPaymentEnabled= false;

   private BigDecimal paymentAmount;

   private String currency;

   private UUID branchId;


}
