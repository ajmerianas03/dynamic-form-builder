package com.dyform.dynamic_forms.controller;

import com.dyform.dynamic_forms.dto.FieldRequestDTO;
import com.dyform.dynamic_forms.dto.FormFieldDTO;
import com.dyform.dynamic_forms.entity.FormField;
import com.dyform.dynamic_forms.service.FormFieldService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/forms/{formId}/fields")
@AllArgsConstructor
public class FormFieldController {
    private final FormFieldService formFieldService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FormFieldDTO> addFieldToForm(@PathVariable UUID formId, @RequestBody FieldRequestDTO fieldRequestDTO){
        FormFieldDTO formFieldDTO = formFieldService.addFieldToForm(formId,fieldRequestDTO);
        return  ResponseEntity.status(201).body(formFieldDTO);
    }

    @PutMapping("/{fieldId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FormFieldDTO> updateField(@PathVariable UUID fieldId, @RequestBody FieldRequestDTO fieldRequestDTO){
        FormFieldDTO updatedFieldDTO = formFieldService.updateField(fieldId,fieldRequestDTO);
        return ResponseEntity.ok(updatedFieldDTO);
    }

    @DeleteMapping("/{fieldId}")
    @PreAuthorize("hasRole('ADMIN')")
    public  ResponseEntity<Void> deleteField(@PathVariable UUID fieldId){
        formFieldService.deleteField(fieldId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUBADMIN')")
    public ResponseEntity<List<FormFieldDTO>> getFieldsByFormId(
            @PathVariable UUID formId) {

        return ResponseEntity.ok(
                formFieldService.getFieldsByFormId(formId)
        );
    }
}
