package com.hrd.basic.myprojectapi.exception;
/**********************************************************************
 * Original Author: Huot Chansreynich
 * Created Date: 12/07/2021
 * Development Group: HRD Group
 * Description: Custom Exception To Handle Permission
 **********************************************************************/
public class PermissionDeniedException extends Exception{
    public PermissionDeniedException(String message) {
        super(message);
    }
}
