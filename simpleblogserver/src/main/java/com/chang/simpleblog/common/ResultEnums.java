package com.chang.simpleblog.common;

/**
 * describe:
 *      返回实体枚举
 * @author changel
 * @date 2019/08/04
 */
public enum ResultEnums {

    SUCCESS(200, "请求成功"),
    BAD_REQUEST_ERROR(400, "无效请求"),
    NOT_FOUND_ERROR(404, "请求的页面不存在"),
    ERROR(500, "系统错误"),
    PARAM_ERROR(2000, "业务参数错误");

    private Integer code;
    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
