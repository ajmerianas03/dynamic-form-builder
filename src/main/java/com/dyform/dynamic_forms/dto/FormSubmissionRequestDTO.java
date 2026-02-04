package com.dyform.dynamic_forms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class FormSubmissionRequestDTO {

    private String submittedBy;

    private Map<UUID,String> values;
}
