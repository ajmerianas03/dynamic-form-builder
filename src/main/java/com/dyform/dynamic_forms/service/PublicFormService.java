package com.dyform.dynamic_forms.service;

import com.dyform.dynamic_forms.dto.FormSubmissionRequestDTO;
import com.dyform.dynamic_forms.dto.FormSubmissionResponseDTO;
import com.dyform.dynamic_forms.dto.PublicFormDTO;

import java.util.UUID;

public interface PublicFormService {
    PublicFormDTO getPublicForm(UUID formId);

    FormSubmissionResponseDTO submitForm(UUID formId, FormSubmissionRequestDTO request);
}
