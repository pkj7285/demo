package com.example.demo.domain.controller;

import com.example.demo.domain.dto.DemoDto;
import com.example.demo.domain.dto.DemoReqDto;
import com.example.demo.util.MessageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
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
//    public List<String> list(@Valid DemoReqDto req, BindingResult bindingResult){
//
//        if(bindingResult.hasErrors()){
//
//            StringBuilder errors = new StringBuilder();
//
//            Iterator<ObjectError> iterator = bindingResult.getAllErrors().iterator();
//            if (iterator.hasNext()) {
//                ObjectError error = iterator.next();
//                if (error instanceof FieldError) {
//                    FieldError fieldError = (FieldError) error;
//                    Map<String, Object> jsonMap = new HashMap<>();
//                    String errorField = fieldError.getField();
//
//                    if (errorField.indexOf('[') != -1) {
//                        jsonMap.put("state", errorField.substring(0, errorField.indexOf('[')));
//                        jsonMap.put("field", errorField.substring(errorField.indexOf(']') + 2));
//                        jsonMap.put(
//                                "index",
//                                Integer.parseInt(
//                                        errorField.substring(
//                                                errorField.indexOf('[') + 1, errorField.indexOf(']'))));
//                        jsonMap.put("message", fieldError.getDefaultMessage());
//                    } else {
//                        jsonMap.put("field", fieldError.getField());
//                        jsonMap.put("message", fieldError.getDefaultMessage());
//                    }
//
//                    ObjectMapper objectMapper = new ObjectMapper();
//                    try {
//                        errors.append(objectMapper.writeValueAsString(jsonMap));
//                    } catch (JsonProcessingException e) {
////                        log.error(e.getMessage(), e);
//                        errors.append(error.getDefaultMessage());
//                    }
//                } else {
//                    errors.append(error.getDefaultMessage());
//                }
//            }
//
//        }
//
//        List<String> list = new ArrayList<String>();
//
//        LocalDateTime currentDate = LocalDateTime.now();
//        DemoDto param = DemoDto.builder().vocSno(1).contNo(req.getContNo()).reqCntn(req.getReqCntn()).crtDt(currentDate).build();
//
//
//        return list;
//    }
}

