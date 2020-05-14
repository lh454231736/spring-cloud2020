package com.mytest.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description 统一的apiResult
 * @Author lh
 * @Date 2020/5/14 10:31
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class ApiResult {
    private boolean flag;
    private String message;
    private Object object;

    private ApiResult(){}
    public static ApiResult success(){
        return new ApiResult(true, "操作成功！", null);
    }
    public static ApiResult successResult(Object o, String message, String ... args){
        return new ApiResult(true, String.format(message, args), o);
    }
    public static ApiResult failResultMessage(String message){
        return new ApiResult(false, message, null);
    }
}
