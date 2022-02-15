package com.zimug.boot.lanuch;

import lombok.Data;

@Data
public class AjaxResponse {

    private boolean isok;
    private int code; //200 OK|400 Client Error|500 Server Error
    private String message;
    private Object data;

    public AjaxResponse(){}

    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("查詢成功");
        ajaxResponse.setData(obj);

        return ajaxResponse;
    }

    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("查詢成功");

        return ajaxResponse;
    }

}
