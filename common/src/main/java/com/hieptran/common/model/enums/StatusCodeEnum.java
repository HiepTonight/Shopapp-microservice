package com.hieptran.common.model.enums;

public enum StatusCodeEnum {
    //EXCEPTION
    EXCEPTION("EXCEPTION"), // Exception
    EXCEPTION0400("EXCEPTION0400"), // Bad request
    EXCEPTION0404("EXCEPTION0404"), // Not found
    EXCEPTION0503("EXCEPTION0503"), // Http message not readable
    EXCEPTION0504("EXCEPTION0504"), // Missing servlet request parameter
    EXCEPTION0505("EXCEPTION0505"), // Access Denied/Not have permission

    //LOGIN
    LOGIN1200("LOGIN1200"), // Login successfully

    LOGIN0201("LOGIN0201"), // Login failed because verify authorization code failed


    //ORDER
    ORDER1200("ORDER1200"), // Order created successfully

    ORDER0200("ORDER0200"); // Order get/saved failed

    public final String value;

    StatusCodeEnum(String i) {
        value = i;
    }
}
