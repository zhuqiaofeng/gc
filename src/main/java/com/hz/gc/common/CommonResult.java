package com.hz.gc.common;
;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
/**
 *  统一结果返回类型
 *  code 代表状态码
 *  msg 代表成功or失败
 *  data 存放返回实际数据 key --> 返回数据名称  value --> 返回的实际数据
 *  例如: put.("data",集合)
 *
 *  逻辑判断无误返回前端则调用 --> CommonResult.ok() ;
 *  需要返回数据则 CommonResult.ok().data(key,value) 或 data(Map集合)
 *  有误则 --> CommonResult.error()
 */
public class CommonResult implements Serializable {

    private Integer code;
    private String msg;
    private Map<String,Object> data = new HashMap<>();


    public static CommonResult ok(){

        CommonResult r = new CommonResult();
        r.setCode(ResponseState.SUCCESS_CODE);
        r.setMsg("成功");
        Map<String,Object> map = new HashMap<>();

        return r;
    }


    public static CommonResult error(){

        CommonResult r = new CommonResult();
        r.setCode(ResponseState.SERVER_ERROR);
        r.setMsg("失败");
        return r;
    }

    public CommonResult code(Integer code){
        this.setCode(code);
        return this;
    }

    public CommonResult msg(String msg){
        this.setMsg(msg);
        return this;
    }


    public CommonResult data(String key,Object value){
        data.put(key,value);
        return this;
    }

    public CommonResult data(Map<String,Object> map){
        this.data = map;
        return this;
    }

}
