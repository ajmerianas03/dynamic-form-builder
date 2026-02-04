package com.dyform.dynamic_forms.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseValueDTO {
    private String fieldLabel;
    private String value;
}
