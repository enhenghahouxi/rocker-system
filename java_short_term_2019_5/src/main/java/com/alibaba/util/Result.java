package com.alibaba.util;




/**
 * @author liushiyao
 * 返回结果集对象
 */

public class Result{

    //返回错误码
    private Integer code;
    //返回信息
    private String message;
    //返回对象
    private Object data;
    
    private Object data2;

    
    private Result(Object data) {
        super();
        this.data = data;
    }

    private Result(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    private Result(Integer code, String message, Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    private Result(Integer code, String message, Object data,Object data2) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
        this.data2 = data2;
    }



	public static Result create(Integer code, String message) {
        return new Result(code, message);
    }

    public static Result create(Integer code, String message, Object data) {
        return new Result(code, message, data);
    }
    
    public static Result create(Object data) {
        return new Result(data);
    }
    
    public static Result create(Integer code, String message, Object data,Object data2) {
        return new Result(code, message, data,data2);
    }
    
    public static Result create(Integer code, String message, int showcontentdefinition1,int showcontentdefinition2) {
        return new Result(code, message, showcontentdefinition1,showcontentdefinition2);
    }
    
    public static Result create(Integer code, String message, int setwin) {
        return new Result(code, message, setwin);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
