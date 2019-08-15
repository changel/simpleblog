package com.chang.simpleblog.common;

/**
 * describe:
 *      统一返回实体
 * @author changel
 * @date 2019/08/04
 */
public class ResponseData<T> {

    private Integer code;

    private String msg;

    private T data;

    //返回状态  默认为false
    private Boolean status;

    public ResponseData(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.status = false;
    }

    public ResponseData(Integer code, String msg, T data,Boolean status) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.status = status;
    }

    public ResponseData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.status = false;
    }

    public ResponseData(Integer code, String msg,Boolean status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public ResponseData(ResultEnums resultEnums) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
        this.status = resultEnums.getStatus();
    }

    public ResponseData(ResultEnums resultEnums, T data) {
        this.code = resultEnums.getCode();
        this.msg = resultEnums.getMsg();
        this.data = data;
        this.status = resultEnums.getStatus();
    }

    public ResponseData() {
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
