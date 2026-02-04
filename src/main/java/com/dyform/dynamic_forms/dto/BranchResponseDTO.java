package com.dyform.dynamic_forms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BranchResponseDTO {

    private UUID branchId;

    private String branchName;

    private String address;

    private UUID adminId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
