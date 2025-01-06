package com.example.demo.domain.dto.common;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CommonDto {
    private String crtId;
    private String updtId;
    private String corpCd;
}


