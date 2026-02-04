package com.dyform.dynamic_forms.dto;

import com.dyform.dynamic_forms.entity.ResponseStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateResponseStatusDTO {
    private ResponseStatus status;
}
