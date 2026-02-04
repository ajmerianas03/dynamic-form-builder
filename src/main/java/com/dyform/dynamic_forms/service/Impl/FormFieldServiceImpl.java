package com.dyform.dynamic_forms.service.Impl;

import com.dyform.dynamic_forms.dto.FieldRequestDTO;
import com.dyform.dynamic_forms.dto.FormFieldDTO;
import com.dyform.dynamic_forms.entity.FieldType;
import com.dyform.dynamic_forms.entity.Form;
import com.dyform.dynamic_forms.entity.FormField;
import com.dyform.dynamic_forms.repository.FormFieldRepository;
import com.dyform.dynamic_forms.repository.FormRepository;
import com.dyform.dynamic_forms.service.FormFieldService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FormFieldServiceImpl implements FormFieldService {

    private final FormRepository formRepository;
    private final FormFieldRepository formFieldRepository;
    @Override
    public FormFieldDTO addFieldToForm(UUID formId, FieldRequestDTO fieldRequestDTO) {
        Form form = formRepository.findById(formId)
                .orElseThrow(()->new RuntimeException("Form not Found"));

        FormField  formField = FormField.builder()
                .form(form)
                .fieldLabel(fieldRequestDTO.getFieldLabel())
                .fieldType(FieldType.valueOf(fieldRequestDTO.getFieldType()))
                .fieldOrder(fieldRequestDTO.getFieldOrder())
                .options(fieldRequestDTO.getOptions())
                .isRequired(fieldRequestDTO.getIsRequired())
                .build();
        formFieldRepository.save(formField);



        return toFormFieldDTO(formField);
    }



    @Override
    public FormFieldDTO updateField(UUID fieldId, FieldRequestDTO fieldRequestDTO) {
        FormField formField = formFieldRepository.findById(fieldId)
                .orElseThrow(()-> new RuntimeException("Form Field Not Found"));

        formField.setFieldLabel(fieldRequestDTO.getFieldLabel());
        formField.setFieldType(FieldType.valueOf(fieldRequestDTO.getFieldType().toUpperCase()));
        formField.setFieldOrder(fieldRequestDTO.getFieldOrder());
        formField.setOptions(fieldRequestDTO.getOptions());
        formField.setIsRequired(fieldRequestDTO.getIsRequired());
        formFieldRepository.save(formField);

        return toFormFieldDTO(formField);
    }

    public void deleteField(UUID fieldId) {
        formFieldRepository.deleteById(fieldId);
    }

    @Override
    public List<FormFieldDTO> getFieldsByFormId(UUID formId) {


        formRepository.findById(formId)
                .orElseThrow(() -> new RuntimeException("Form not found"));

        return formFieldRepository
                .findByForm_FormIdOrderByFieldOrderAsc(formId)
                .stream()
                .map(this::toFormFieldDTO)
                .toList();
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
