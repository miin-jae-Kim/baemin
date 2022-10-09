package com.homes.baemin.dto;

import com.homes.baemin.common.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorDto {

    private HttpStatus httpStatus;
    private String message;

    public ErrorDto(ErrorCode errorCode) {
        this.httpStatus = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }
}
