package com.hz.gc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GcException extends RuntimeException{

    private Integer code;   // 状态码

    private String msg; // 异常信息


    public GcException(String msg){
        super(msg);
    }
}
