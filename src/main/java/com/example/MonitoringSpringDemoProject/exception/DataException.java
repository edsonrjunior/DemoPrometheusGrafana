package com.example.MonitoringSpringDemoProject.exception;

import java.io.Serial;

public class DataException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;
    public DataException(String message){
        super(message);
    }
}
