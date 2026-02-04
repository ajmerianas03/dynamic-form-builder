package com.dyform.dynamic_forms.controller;

import com.dyform.dynamic_forms.dto.BranchRequestDTO;
import com.dyform.dynamic_forms.dto.BranchResponseDTO;
import com.dyform.dynamic_forms.service.BranchService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin/branches")
@AllArgsConstructor
public class BranchController {

    private BranchService branchService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BranchResponseDTO> createBranch(@Valid @RequestBody BranchRequestDTO branchRequestDTO){
        BranchResponseDTO branchResponseDTO = branchService.createBranch(branchRequestDTO);
        return ResponseEntity.ok(branchResponseDTO);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<BranchResponseDTO>> getAllBranches(){
        List<BranchResponseDTO>  branches = branchService.getAllBranches();
        return ResponseEntity.ok(branches);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BranchResponseDTO> getBranchById(@PathVariable("id")UUID branchId){
        return ResponseEntity.ok(branchService.getBranchById(branchId));
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BranchResponseDTO> updateBranch(@PathVariable("id")UUID branchId,
                                                          @Valid @RequestBody BranchRequestDTO branchRequestDTO){
        return ResponseEntity.ok(branchService.updateBranch(branchId,branchRequestDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteBranch(@PathVariable("id") UUID branchId) {
        branchService.deleteBranch(branchId);
        return ResponseEntity.noContent().build();
    }

}
