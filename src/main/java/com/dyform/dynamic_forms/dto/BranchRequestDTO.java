package com.dyform.dynamic_forms.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BranchRequestDTO {

    @NotBlank
    @Size(max = 150, message = "Branch name cannot Exceed 150 Characters")
    private String branchName;

    private String address;


}
