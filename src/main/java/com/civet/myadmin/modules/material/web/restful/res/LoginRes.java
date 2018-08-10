package com.civet.myadmin.modules.material.web.restful.res;

import com.civet.myadmin.modules.material.entity.detail.MaterialDetail;
import org.apache.shiro.subject.Subject;

public class LoginRes extends BaseRes{
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
