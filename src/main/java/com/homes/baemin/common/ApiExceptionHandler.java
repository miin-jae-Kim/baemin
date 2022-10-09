package com.homes.baemin.common;

import com.homes.baemin.common.exception.CustomException;
import com.homes.baemin.common.exception.ErrorCode;
import com.homes.baemin.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({ CustomException.class })
    protected ResponseEntity handleException(CustomException customException) {

        ErrorCode errorCode = customException.getErrorCode();
        ErrorDto errorDto = new ErrorDto(errorCode);

        return new ResponseEntity(
                errorDto,
                errorCode.getStatus()
        );
    }
}
