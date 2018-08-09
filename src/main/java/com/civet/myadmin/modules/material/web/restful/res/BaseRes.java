package com.civet.myadmin.modules.material.web.restful.res;

public class BaseRes {
    private Integer retCode;
    private String retMsg;

    public BaseRes() {

    }

    public BaseRes(Integer retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
