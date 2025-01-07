package com.example.demo.domain.controller;

import com.example.demo.domain.dto.DemoReqDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import java.util.*;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/demo/v1")
public class DemoController {
    /**
     *
     */
    @Operation(summary = "리스트", description = "리스트")
    @GetMapping("/list")
    public List<String> list(@Valid DemoReqDto req){
        List<String> list = new ArrayList<String>();
        return list;
    }

}

