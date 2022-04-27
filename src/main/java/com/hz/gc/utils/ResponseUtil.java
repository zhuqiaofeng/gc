package com.hz.gc.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hz.gc.common.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {

    public static  void out(HttpServletResponse response, CommonResult r)  {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        try {
            mapper.writeValue(response.getWriter(), r);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
