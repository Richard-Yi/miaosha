package com.imooc.miaosha.result;

/**
 * @author Richard_yyf
 * @Date 2018/10/16
 * @Description
 */
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    /**
     * 成功时候的调用
     * */
    public static <T> Result<T> success(T data){
        return new  Result<T>(data);
    }

    /**
     * 失败时候的调用
     * */
    public static <T> Result<T> error(CodeEnum codeEnum){
        return new  Result<T>(codeEnum);
    }

    private Result(T data) {
        this.code = CodeEnum.SUCCESS.getCode();
        this.msg = CodeEnum.SUCCESS.getMsg();
        this.data = data;
    }

    private Result(CodeEnum codeEnum) {
        if(codeEnum == null) {
            return;
        }
        this.code = codeEnum.getMsg();
        this.msg = codeEnum.getCode();
    }

    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public T getData() {
        return data;
    }
}