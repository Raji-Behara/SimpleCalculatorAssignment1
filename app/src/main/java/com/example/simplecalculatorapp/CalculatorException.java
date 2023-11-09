package com.example.simplecalculatorapp;

public class CalculatorException extends  RuntimeException{


    private String errorMessage;

    private  int errorCode;

    CalculatorException(){

    }
    CalculatorException(String errorMessage,int errorCode){
this.errorMessage=errorMessage;
this.errorCode=errorCode;

    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }



    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }




}
