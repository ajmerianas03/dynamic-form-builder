package com.dyform.dynamic_forms.service;

import com.dyform.dynamic_forms.dto.FieldRequestDTO;
import com.dyform.dynamic_forms.dto.FormFieldDTO;

import java.util.List;
import java.util.UUID;

public interface FormFieldService {
    FormFieldDTO addFieldToForm(UUID formId, FieldRequestDTO fieldRequestDTO);

    FormFieldDTO updateField(UUID fieldId, FieldRequestDTO fieldRequestDTO);

    void deleteField(UUID fieldId);

    List<FormFieldDTO> getFieldsByFormId(UUID formId);
}
