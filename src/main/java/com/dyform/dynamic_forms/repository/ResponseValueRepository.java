package com.dyform.dynamic_forms.repository;

import com.dyform.dynamic_forms.entity.ResponseValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResponseValueRepository extends JpaRepository<ResponseValue, UUID> {
    List<ResponseValue> findByResponse_ResponseId(UUID responseId);
}
