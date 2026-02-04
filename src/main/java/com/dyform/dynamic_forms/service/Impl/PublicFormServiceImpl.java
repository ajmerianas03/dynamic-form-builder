package com.dyform.dynamic_forms.service.Impl;

import com.dyform.dynamic_forms.dto.FormFieldDTO;
import com.dyform.dynamic_forms.dto.FormSubmissionRequestDTO;
import com.dyform.dynamic_forms.dto.FormSubmissionResponseDTO;
import com.dyform.dynamic_forms.dto.PublicFormDTO;
import com.dyform.dynamic_forms.entity.*;
import com.dyform.dynamic_forms.repository.FormFieldRepository;
import com.dyform.dynamic_forms.repository.FormRepository;
import com.dyform.dynamic_forms.repository.FormResponseRepository;
import com.dyform.dynamic_forms.repository.ResponseValueRepository;
import com.dyform.dynamic_forms.service.PublicFormService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor

public class PublicFormServiceImpl implements PublicFormService {
    
    private final FormRepository formRepository;
    private final FormFieldRepository formFieldRepository;
    private final FormResponseRepository formResponseRepository;

    private final ResponseValueRepository responseValueRepository;
    @Override
    public PublicFormDTO getPublicForm(UUID formId) {
        Form form = formRepository.findByFormIdAndStatus(formId, FormStatus.PUBLISHED)
                .orElseThrow(()-> new RuntimeException("Form not Found"));
        List<FormFieldDTO> fields = formFieldRepository
                .findByForm_FormIdOrderByFieldOrderAsc(formId)
                .stream()
                .map(this::toFormFieldDTO)
                .toList();


        return PublicFormDTO.builder()
                .formId(form.getFormId())
                .formName(form.getFormName())
                .isPaymentEnabled(form.getIsPaymentEnabled())
                .fieldDTOS(fields)
                .build();
    }



    @Override
    @Transactional
    public FormSubmissionResponseDTO submitForm(UUID formId,
                                                FormSubmissionRequestDTO request) {
        Form form = formRepository.findByFormIdAndStatus(formId, FormStatus.PUBLISHED)
                .orElseThrow(()-> new RuntimeException("FOrm not Found"));

        List<FormField> fields = formFieldRepository.findByForm_FormIdOrderByFieldOrderAsc(formId);

        for(FormField field : fields){
            if(Boolean.TRUE.equals(field.getIsRequired())){
                if (!request.getValues().containsKey(field.getFieldId())
                        || request.getValues().get(field.getFieldId()).isBlank()) {
                    throw new RuntimeException( "Missing Required Field: " + field.getFieldLabel());

                }
            }
        }
        FormResponse response = FormResponse.builder()
                .form(form)
                .submittedBy(request.getSubmittedBy())
                .responseStatus(ResponseStatus.PENDING).build();
        formResponseRepository.save(response);

        for (FormField field : fields) {
            if (request.getValues().containsKey(field.getFieldId())) {

                ResponseValue value = new ResponseValue();
                value.setResponse(response);
                value.setFormField(field);
                value.setValue(request.getValues().get(field.getFieldId()));

                responseValueRepository.save(value);
            }
        }

        return FormSubmissionResponseDTO.builder()
                .responseId(response.getResponseId())
                .status(ResponseStatus.PENDING.name())
                .build();

    }

    private FormFieldDTO toFormFieldDTO(FormField formField) {
        return FormFieldDTO.builder()
                .fieldId(formField.getFieldId())
                .fieldLabel(formField.getFieldLabel())
                .fieldType(formField.getFieldType().toString())
                .fieldOrder(formField.getFieldOrder())
                .options(formField.getOptions())
                .isRequired(formField.getIsRequired())
                .build();
    }
}
