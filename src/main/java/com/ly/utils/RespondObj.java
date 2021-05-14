package com.ly.utils;

public class RespondObj {
    private Integer status;
    private Object object;



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "RespondObj [status=" + status + ", object=" + object + "]";
    }

    public RespondObj(int i, Object object2) {
        super();
        this.status = i;
        this.object =object2;
    }

}
