package com.homes.baemin.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {


    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "Invalid Parameter"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User Not Found");

    private final HttpStatus status;
    private final String message;
}
