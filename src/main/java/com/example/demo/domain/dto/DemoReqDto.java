package com.example.demo.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@Data
@Builder
public class DemoReqDto {
    @Schema(description = "계약번호")
    @NotBlank(message = "값이 없습니다.")
    private String contNo;

    @Schema(description = "내용")
    @NotBlank(message = "값이 없습니다.")
    private String reqCntn;

    @Schema(description = "배열")
    @Size(min=1)
    @NonNull
    private String[] str;
}