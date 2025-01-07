package com.example.demo.exception.advice;

import com.example.demo.common.dto.CommonResponse;
import com.example.demo.constants.ConstErrorInfo;
import com.example.demo.constants.ConstError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lge.csms.constants.ConstError;
//import com.lge.csms.constants.ConstErrorInfo;
//import com.lge.csms.exception.BusinessException;
//import com.lge.csms.exception.RESTException;
import com.example.demo.exception.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@ControllerAdvice // 모든 컨트롤러에서 발생하는 예외를 잡아서 처리
public class DefaultExceptionAdvice {


    @Value("${spring.messages.basename}")
    private String[] basename;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected <T> ResponseEntity<CommonResponse<T>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
//        log.info(">>>>>>> getMessage >>>> {} ",MessageUtil.getMessage("member.success"));
//        log.info(">>>>>>> basename >>>> {}",  basename[2]);

        StringBuilder errors = new StringBuilder();

        Iterator<ObjectError> iterator = ex.getBindingResult().getAllErrors().iterator();
        if (iterator.hasNext()) {
            ObjectError error = iterator.next();
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                Map<String, Object> jsonMap = new HashMap<>();
                String errorField = fieldError.getField();

                if (errorField.indexOf('[') != -1) {
                    jsonMap.put("state", errorField.substring(0, errorField.indexOf('[')));
                    jsonMap.put("field", errorField.substring(errorField.indexOf(']') + 2));
                    jsonMap.put(
                            "index",
                            Integer.parseInt(
                                    errorField.substring(
                                            errorField.indexOf('[') + 1, errorField.indexOf(']'))));
                    jsonMap.put("i18n", fieldError.getDefaultMessage());
                } else {
                    jsonMap.put("field", fieldError.getField());
                    jsonMap.put("i18n", fieldError.getDefaultMessage());
                }

                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    errors.append(objectMapper.writeValueAsString(jsonMap));
                } catch (JsonProcessingException e) {
                    log.error(e.getMessage(), e);
                    errors.append(error.getDefaultMessage());
                }
            } else {
                errors.append(error.getDefaultMessage());
            }
        }
        ConstErrorInfo constErrorInfo = ConstError.BadRequest;
        constErrorInfo.setMessage(errors.toString());
        return getFaileResponse(constErrorInfo);
    }

//    @ExceptionHandler(SQLException.class)
//    protected <T> ResponseEntity<CommonResponse<T>> handleSQLException(SQLException ex) {
//        ConstErrorInfo constErrorInfo = ConstError.SQLException;
//        return getFaileResponse(constErrorInfo);
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    protected <T> ResponseEntity<CommonResponse<T>> handleConstraintViolationException(
//            ConstraintViolationException ex) {
//        ConstErrorInfo constErrorInfo = ConstError.SQLException;
//        return getFaileResponse(constErrorInfo);
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    protected <T> ResponseEntity<CommonResponse<T>> handleNullPointerException(
//            NullPointerException ex) {
//        ConstErrorInfo constErrorInfo = ConstError.InternalServerError;
//        return getFaileResponse(constErrorInfo);
//    }
//
//
//    @ExceptionHandler(BusinessException.class)
//    protected <T> ResponseEntity<CommonResponse<T>> handleException(
//            final BusinessException businessException) {
//        return new ResponseEntity<>(
//                CommonResponse.<T>builder()
//                        .successOrNot("N")
//                        .statusCode(String.valueOf(businessException.getCode()))
//                        .errorMessage(
//                                new Error(businessException.getError()).getError().getMessage())
//                        .build(),
//                OK);
//    }
//
//    @ExceptionHandler(RESTException.class)
//    protected <T> ResponseEntity<CommonResponse<T>> handleException(
//            final RESTException restException) {
//        return new ResponseEntity<>(
//                CommonResponse.<T>builder()
//                        .successOrNot("N")
//                        .statusCode(String.valueOf(restException.getCode()))
//                        .errorMessage(new Error(restException.getError()).getError().getMessage())
//                        .build(),
//                OK);
//    }


    //CommonResponse에 담으면 무조건 status code 200으로 내려감... to-do
    private <T> ResponseEntity<CommonResponse<T>> getFaileResponse(ConstErrorInfo constErrorInfo) {
       ErrorDto errorDto = new ErrorDto(constErrorInfo);
        return new ResponseEntity<>(
                CommonResponse.<T>builder()
                        .successOrNot("N")
                        .statusCode(String.valueOf(constErrorInfo.getResponseCode()))
                        .errorMessage(errorDto.getMessage())
                        .build(),
                OK);
    }
}
