package com.spring.movi.utils;

import com.spring.movi.dto.ReturnStatus;

public class SetStatusReturn {
    public  static ReturnStatus setStatus(boolean b, String status, String desc){
        ReturnStatus returnStatus = new ReturnStatus();
        returnStatus.setStatus(b);
        returnStatus.setSetStatus(status);
        returnStatus.setDescription(desc);
        return returnStatus;
    }
}
