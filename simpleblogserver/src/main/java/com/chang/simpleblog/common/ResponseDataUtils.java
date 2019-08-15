package com.chang.simpleblog.common;

/**
 * describe:
 *      返回实体组装工具类
 * @author changel
 * @date 2019/08/04
 */
public class ResponseDataUtils {
    /**
     * 带实体的统一返回
     *
     * @param data 实体
     * @param <T>  实体类型
     * @return
     */
    public static <T> ResponseData buildSuccess(T data) {
        return new ResponseData<T>(ResultEnums.SUCCESS, data);
    }

    public static ResponseData buildSuccess() {
        return new ResponseData(ResultEnums.SUCCESS);
    }

    public static ResponseData buildSuccess(String msg) {
        return new ResponseData(ResultEnums.SUCCESS.getCode(), msg);
    }

    public static ResponseData buildResponseData(Integer code, String msg) {
        return new ResponseData(code, msg);
    }

    public static ResponseData buildResponseData(Integer code, String msg,Boolean status) {
        return new ResponseData(code, msg, status);
    }

    public static <T> ResponseData buildResponseData(Integer code, String msg, T data, Boolean status) {
        return new ResponseData<T>(code, msg, data,status);
    }

    public static <T> ResponseData buildResponseData(Integer code, String msg, T data) {
        return new ResponseData<T>(code, msg, data);
    }

    public static ResponseData buildResponseData(ResultEnums resultEnums) {
        return new ResponseData(resultEnums);
    }

    public static <T> ResponseData buildError(T data) {
        return new ResponseData<T>(ResultEnums.ERROR, data);
    }

    public static ResponseData buildError() {
        return new ResponseData(ResultEnums.ERROR);
    }

    public static ResponseData buildError(String msg) {
        return new ResponseData(ResultEnums.ERROR.getCode(), msg,ResultEnums.ERROR.getStatus());
    }

    public static ResponseData buildOK(String msg) {
        return new ResponseData(ResultEnums.OK.getCode(), msg,ResultEnums.OK.getStatus());
    }
    public static ResponseData buildOK() {
        return buildOK("");
    }

    public static ResponseData buildFail(String msg) {
        return new ResponseData(ResultEnums.FAIL.getCode(), msg,ResultEnums.FAIL.getStatus());
    }

    public static ResponseData buildErrorResponseData(Integer code, String msg) {
        return buildResponseData(code,msg,false);
    }

    public static <T> ResponseData buildErrorResponseData(Integer code, String msg, T data) {
        return buildResponseData(code,msg,data,false);
    }

    public static ResponseData buildSuccessResponseData(Integer code, String msg) {
        return buildResponseData(code,msg,true);
    }

    public static <T> ResponseData buildSuccessResponseData(Integer code, String msg, T data) {
        return buildResponseData(code,msg,data,true);
    }
}
