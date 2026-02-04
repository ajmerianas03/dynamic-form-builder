package com.dyform.dynamic_forms.service;

import com.dyform.dynamic_forms.dto.BranchRequestDTO;
import com.dyform.dynamic_forms.dto.BranchResponseDTO;

import java.util.List;
import java.util.UUID;

public interface BranchService {

    BranchResponseDTO createBranch(BranchRequestDTO branchRequestDTO);

    BranchResponseDTO updateBranch(UUID branchId, BranchRequestDTO branchRequestDTO);

    BranchResponseDTO getBranchById(UUID branchId);

    List<BranchResponseDTO> getAllBranches();

    void deleteBranch(UUID branchId);


}
