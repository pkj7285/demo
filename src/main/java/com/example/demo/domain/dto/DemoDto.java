package com.example.demo.domain.dto;

import com.example.demo.domain.dto.common.CommonDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class DemoDto extends CommonDto {
    private int  vocSno;
    private String contNo;
    private String reqCntn;
    private LocalDateTime crtDt;

    @Schema(description = "배열")
    @Size(min=1)
    @NonNull
    private String[] str;

}