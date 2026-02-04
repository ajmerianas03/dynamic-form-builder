package com.dyform.dynamic_forms.service;

import com.dyform.dynamic_forms.dto.FormRequestDTO;
import com.dyform.dynamic_forms.dto.FormResponseDTO;

import java.util.List;
import java.util.UUID;

public interface FormService {
    List<FormResponseDTO> getAllForms();

    FormResponseDTO createForm(FormRequestDTO formRequestDTO);

    FormResponseDTO getFormById(UUID id);

    FormResponseDTO updateForm(UUID id, FormRequestDTO formRequestDTO);

    void deleteForm(UUID id);
}
