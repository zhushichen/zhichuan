package com.civet.myadmin.modules.material.web.restful.req;

import com.civet.myadmin.modules.material.entity.detail.MaterialDetail;

public class LoginReq extends BaseReq{
    private String name;
    private String password;

    public LoginReq() {
        super.setMsgCode("Login");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
