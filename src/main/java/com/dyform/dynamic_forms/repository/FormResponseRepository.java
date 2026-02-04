package com.dyform.dynamic_forms.repository;

import com.dyform.dynamic_forms.entity.FormResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FormResponseRepository extends JpaRepository<FormResponse, UUID> {

    List<FormResponse> findByForm_Admin_Id(UUID adminId);


    List<FormResponse> findByAssignedTo_Id(UUID userId);

    List<FormResponse> findByAssignedTo(String username);
}
