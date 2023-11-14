package com.plas.hope.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Auther:Plasmon222
 * @Date: 2023/9/27/14:27
 * @Description:
 */
public class OutputObject implements Serializable {
    private static final long serialVersionUID= -3008727041903030893L;
    private String rtnCode;
    private String rtnMsg;
    private Map<String,Object> bean;
    private List<Map<String,Object>> beans;
    private Object object;

    public OutputObject() {
    }

    public String getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(String rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getRtnMsg() {
        return rtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }

    public Map<String, Object> getBean() {
        return bean;
    }

    public void setBean(Map<String, Object> bean) {
        this.bean = bean;
    }

    public List<Map<String, Object>> getBeans() {
        return beans;
    }

    public void setBeans(List<Map<String, Object>> beans) {
        this.beans = beans;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
    public String toString(){
        StringBuilder builder =new StringBuilder();
        builder.append("CsfOutObject[rtnCode=");
        builder.append(this.rtnCode);
        builder.append(",[rtnMsg=");
        builder.append(this.rtnMsg);
        builder.append(",bean=");
        builder.append(this.bean);
        builder.append(",beans=");
        builder.append(this.beans);
        builder.append(",object=");
        builder.append(this.object);
        builder.append(",responseEx=");
        builder.append("]");
        return builder.toString();
    }
}
