package com.banbi.tdduserservice.Exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserErrorResult {

    DUPLICATED_USER_REGISTER(HttpStatus.BAD_REQUEST, "Duplicated User Register Request");

    private final HttpStatus httpStatus;
    private final String message;
}
