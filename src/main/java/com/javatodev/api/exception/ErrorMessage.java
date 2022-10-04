package com.javatodev.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {

    private Integer code;

    private String message;

}
