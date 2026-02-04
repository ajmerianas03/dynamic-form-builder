package com.dyform.dynamic_forms.service.Impl;

import com.dyform.dynamic_forms.dto.BranchRequestDTO;
import com.dyform.dynamic_forms.dto.BranchResponseDTO;
import com.dyform.dynamic_forms.entity.Branch;
import com.dyform.dynamic_forms.entity.User;
import com.dyform.dynamic_forms.repository.BranchRepository;
import com.dyform.dynamic_forms.repository.UserRepository;
import com.dyform.dynamic_forms.service.BranchService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    private UserRepository userRepository;



    @Override
    public BranchResponseDTO createBranch(BranchRequestDTO branchRequestDTO) {

        UUID admindId = getCurrentAdminId();

        User admin = userRepository.findById(admindId).
                orElseThrow(()-> new RuntimeException("admin not Found"));

        Branch branch = Branch.builder()
                .branchName(branchRequestDTO.getBranchName())
                .address(branchRequestDTO.getAddress())
                .admin(admin)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        Branch saveBranch = branchRepository.save(branch);


        return mapToDTO(saveBranch);
    }

    @Override
    public BranchResponseDTO updateBranch(UUID branchId, BranchRequestDTO branchRequestDTO) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(()-> new RuntimeException("Branch Not Found"));

        branch.setBranchName(branchRequestDTO.getBranchName());
        branch.setAddress(branchRequestDTO.getAddress());
        branch.setUpdatedAt(LocalDateTime.now());

        Branch updatedBranch = branchRepository.save(branch);





        return mapToDTO(updatedBranch);
    }

    @Override
    public BranchResponseDTO getBranchById(UUID branchId) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(()-> new RuntimeException("Branch Not found"));


        return mapToDTO(branch);
    }

    @Override
    public List<BranchResponseDTO> getAllBranches() {
        return branchRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBranch(UUID branchId) {
        Branch branch = branchRepository.findById(branchId)
                .orElseThrow(()-> new RuntimeException("Branch Not Founded"));

        branchRepository.delete(branch);

    }

    private UUID getCurrentAdminId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof User)) {
            throw new RuntimeException("User not authenticated");
        }

        User user = (User) authentication.getPrincipal();
        return user.getUserId();
    }

    private BranchResponseDTO mapToDTO(Branch branch) {
        return BranchResponseDTO.builder()
                .branchId(branch.getBranchID())
                .branchName(branch.getBranchName())
                .address(branch.getAddress())
                .adminId(branch.getAdmin().getUserId())
                .createdAt(branch.getCreatedAt())
                .updatedAt(branch.getUpdatedAt())
                .build();
    }

}
