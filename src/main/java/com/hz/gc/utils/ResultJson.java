package com.hz.gc.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultJson<T> {
    private Integer code; // 错误代码  0代码成功
    private String msg;
    private T data; //数据

  /*  public ResultJson(Integer code,String msg,T data){
        this.code = code;
        this.msg = this.code>0?"操作成功":"操作失败";
        this.data;
    }*/

    public ResultJson(Integer code){
        this.code = code;
        this.msg = this.code>0?"操作成功":"操作失败";
    }
}
