package com.dyform.dynamic_forms.dto;

import com.dyform.dynamic_forms.entity.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ResponseListDTO {
    private UUID responseId;

    private UUID formId;

    private String formName;

    private String submittedBy;

    private ResponseStatus status;

    private UUID assignTo;

    private LocalDateTime createdAt;

}
