package com.imooc.miaosha.result;

/**
 * @author Richard_yyf
 * @Date 2018/10/16
 * @Description
 */
public enum CodeEnum {

    /** 通用异常 */
    SUCCESS("0", "success"),
    SERVER_ERROR("500100", "服务端异常");

    /** 登录模块 5002XX */

    /** 商品模块 5003XX */

    /** 订单模块 5004XX */

    /** 秒杀模块 5005XX */

    private String code;
    private String msg;

    CodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return msg;
    }

    public static CodeEnum convertByValue(String code) {
        for (CodeEnum st : CodeEnum.values()) {
            if (st.getCode().equals(code)) {
                return st;
            }
        }
        return null;
    }

    public static CodeEnum convertByLabel(String msg) {
        for (CodeEnum st : CodeEnum.values()) {
            if (st.getMsg().equals(msg)) {
                return st;
            }
        }
        return null;
    }
}
