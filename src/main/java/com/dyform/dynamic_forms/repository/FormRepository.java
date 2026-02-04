package com.dyform.dynamic_forms.repository;

import com.dyform.dynamic_forms.entity.Form;
import com.dyform.dynamic_forms.entity.FormStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FormRepository extends JpaRepository<Form, UUID> {
    Optional<Form> findByFormIdAndStatus(UUID formId, FormStatus status);
}
