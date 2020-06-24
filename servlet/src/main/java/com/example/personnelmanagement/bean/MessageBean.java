package com.example.personnelmanagement.bean;

public class MessageBean {
    private String result;
    private String message;

    public MessageBean(String result, String message){
        this.result=result;
        this.message=message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString(){
        return "messageBean [message="+message+",result="+result+"";
    }


}
