package com.dyform.dynamic_forms.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class FormSubmissionResponseDTO {
    private UUID responseId;
    private String status;
}
