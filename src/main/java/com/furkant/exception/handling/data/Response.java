package com.furkant.exception.handling.data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response<T> {

    private int status;

    private String error;

    private String errorCode;

    private String message = "No message available";

    private Boolean success;

    private T data;
}
