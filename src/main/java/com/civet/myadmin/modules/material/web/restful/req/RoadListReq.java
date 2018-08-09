package com.civet.myadmin.modules.material.web.restful.req;

public class RoadListReq{
    private int PageNo;
    private int PageSize;

    public int getPageNo() {
        return PageNo;
    }

    public void setPageNo(int pageNo) {
        PageNo = pageNo;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }
}
