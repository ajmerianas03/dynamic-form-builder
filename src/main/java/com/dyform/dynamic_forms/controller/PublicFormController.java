package com.dyform.dynamic_forms.controller;

import com.dyform.dynamic_forms.dto.FormSubmissionRequestDTO;
import com.dyform.dynamic_forms.dto.FormSubmissionResponseDTO;
import com.dyform.dynamic_forms.dto.PublicFormDTO;
import com.dyform.dynamic_forms.service.PublicFormService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/public/forms")
@AllArgsConstructor
public class PublicFormController {

    private final PublicFormService publicFormService;

    @GetMapping("/{formId}")
    public ResponseEntity<PublicFormDTO> getPublicForm(
            @PathVariable UUID formId) {
        return ResponseEntity.ok(
                publicFormService.getPublicForm(formId)
        );
    }

    @PostMapping("/{formId}/submit")
    public ResponseEntity<FormSubmissionResponseDTO> submitForm(
            @PathVariable UUID formId,
            @RequestBody FormSubmissionRequestDTO request) {

        return ResponseEntity.status(201).body(
                publicFormService.submitForm(formId, request)
        );
    }
}

