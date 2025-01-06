package com.example.demo.domain.dto;

import com.example.demo.domain.dto.common.CommonDto;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class DemoDto extends CommonDto {
    private int  vocSno;
    private String contNo;
    private String reqCntn;
    private LocalDateTime crtDt;

}