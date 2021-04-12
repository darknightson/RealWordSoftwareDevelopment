package com.realworddevelopment.chapter_03;

public class CSVSyntaxException extends RuntimeException {

    private String message;
    private String errorCode;

    public CSVSyntaxException(String errorCode, String message) {
        super(message);
        System.out.println("errorCode + \" , \" + message = " + errorCode + " , " + message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
