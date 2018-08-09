package com.civet.myadmin.modules.material.web.restful.req;

public class BaseReq {
    private String msgCode;
    private String token;
    private Long ts;

    public BaseReq() {
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

}
