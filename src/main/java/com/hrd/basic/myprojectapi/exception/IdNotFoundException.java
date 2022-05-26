package com.hrd.basic.myprojectapi.exception;
/**********************************************************************
 * Original Author: Huot Chansreynich
 * Created Date: 12/07/2021
 * Development Group: HRD Group
 * Description: Custom Exception To Handle Id
 **********************************************************************/
public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String message) {
        super(message);
    }
}
