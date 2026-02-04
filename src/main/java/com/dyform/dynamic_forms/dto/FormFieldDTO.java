package com.dyform.dynamic_forms.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
@Builder
public class FormFieldDTO {
    private UUID fieldId;

    private String fieldLabel;

    private String fieldType;

    private Integer fieldOrder;

    private Boolean isRequired;

    private Map<String,Object> options;

}
