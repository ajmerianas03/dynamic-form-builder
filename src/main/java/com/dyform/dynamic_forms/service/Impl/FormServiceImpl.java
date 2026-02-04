package com.dyform.dynamic_forms.service.Impl;

import com.dyform.dynamic_forms.dto.FormRequestDTO;
import com.dyform.dynamic_forms.dto.FormResponseDTO;
import com.dyform.dynamic_forms.entity.Branch;
import com.dyform.dynamic_forms.entity.Form;
import com.dyform.dynamic_forms.entity.FormStatus;
import com.dyform.dynamic_forms.entity.User;
import com.dyform.dynamic_forms.repository.BranchRepository;
import com.dyform.dynamic_forms.repository.FormRepository;
import com.dyform.dynamic_forms.repository.UserRepository;
import com.dyform.dynamic_forms.service.FormService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FormServiceImpl implements FormService {

    private final FormRepository formRepository;

    private final UserRepository userRepository;

    private final BranchRepository branchRepository;

    @Override
    public List<FormResponseDTO> getAllForms() {
        List<Form> forms = formRepository.findAll();
        return forms.stream().map(this::toFormResponseDTO).collect(Collectors.toList());

    }

    @Override
    public FormResponseDTO createForm(FormRequestDTO formRequestDTO) {
        Branch branch = branchRepository.findById(formRequestDTO.getBranchId())
                .orElseThrow(()-> new RuntimeException("Branch Not Found"));
        User admin = userRepository.findById(branch.getAdmin().getUserId())
                .orElseThrow(()-> new RuntimeException("User Not Found"));
        Form form = Form.builder()
                .formName(formRequestDTO.getFormName())
                .isPaymentEnabled(formRequestDTO.getIsPaymentEnabled())
                .paymentAmount(formRequestDTO.getPaymentAmount())
                .currency(formRequestDTO.getCurrency())
                .status(FormStatus.DRAFT)
                .admin(admin)
                .branch(branch)
                .build();
        Form savedForm =formRepository.save(form);

        return toFormResponseDTO(savedForm);
    }



    @Override
    public FormResponseDTO getFormById(UUID id) {
        Form form = formRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Form Not found"));

        return toFormResponseDTO(form);
    }

    @Override
    public FormResponseDTO updateForm(UUID id, FormRequestDTO formRequestDTO) {
        Form form = formRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Form Not found"));
        form.setFormName(form.getFormName());
        form.setIsPaymentEnabled(form.getIsPaymentEnabled());
        form.setPaymentAmount(form.getPaymentAmount());
        form.setCurrency(form.getCurrency());

        Form updatedForm = formRepository.save(form);

        return toFormResponseDTO(updatedForm);
    }

    @Override
    public void deleteForm(UUID id) {
        Form form = formRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Form Not Found "));

        formRepository.delete(form);

    }

    private FormResponseDTO toFormResponseDTO(Form savedForm) {
        return FormResponseDTO.builder()
                .formId(savedForm.getFormId())
                .formName(savedForm.getFormName())
                .isPaymentEnabled(savedForm.getIsPaymentEnabled())
                .paymentAmount(savedForm.getPaymentAmount())
                .currency(savedForm.getCurrency())
                .status(savedForm.getStatus().toString())
                .build();
    }
}
