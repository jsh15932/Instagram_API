package com.instagram.api.global.result;

import lombok.Getter;


@Getter
public class ResultResponse {

    private Object data;

    public static ResultResponse of(Object data) {
        return new ResultResponse(data);
    }

    public ResultResponse(Object data) {
        this.data = data;
    }
}
