package com.dyform.dynamic_forms.dto;

import com.dyform.dynamic_forms.entity.ResponseStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ResponseDetailDTO {

    private UUID responseId;
    private String formName;
    private String submittedBy;
    private ResponseStatus status;
    private UUID assignedTO;
    private List<ResponseValueDTO> values;
    private LocalDateTime createdAt;
}
