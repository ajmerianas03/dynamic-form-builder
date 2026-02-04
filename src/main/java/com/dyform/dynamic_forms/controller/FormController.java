package com.dyform.dynamic_forms.controller;

import com.dyform.dynamic_forms.dto.FormRequestDTO;
import com.dyform.dynamic_forms.dto.FormResponseDTO;
import com.dyform.dynamic_forms.service.FormService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/forms")
@AllArgsConstructor
public class FormController {

    private final FormService formService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FormResponseDTO> createForm(@Valid @RequestBody FormRequestDTO formRequestDTO) {
        FormResponseDTO formResponseDTO = formService.createForm(formRequestDTO);
        return ResponseEntity.ok(formResponseDTO);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUBADMIN')")
    public ResponseEntity<List<FormResponseDTO>> getAllForms() {
        List<FormResponseDTO> forms = formService.getAllForms();
        return ResponseEntity.ok(forms);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUBADMIN')")
    public ResponseEntity<FormResponseDTO> getFormById(@PathVariable UUID id) {
        FormResponseDTO formResponseDTO = formService.getFormById(id);
        return ResponseEntity.ok(formResponseDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FormResponseDTO> updateForm(@PathVariable UUID id, @Valid @RequestBody FormRequestDTO formRequestDTO) {
        FormResponseDTO updatedForm = formService.updateForm(id, formRequestDTO);
        return ResponseEntity.ok(updatedForm);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteForm(@PathVariable UUID id) {
        formService.deleteForm(id);
        return ResponseEntity.noContent().build();
    }
}
