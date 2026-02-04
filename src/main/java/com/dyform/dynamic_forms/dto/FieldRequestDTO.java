package com.dyform.dynamic_forms.dto;

import lombok.Data;

import java.util.Map;

@Data
public class FieldRequestDTO {
    private String fieldLabel;
    private String fieldType;

    private Integer fieldOrder;

    private Boolean isRequired = false;

    private Map<String,Object> options;
}
