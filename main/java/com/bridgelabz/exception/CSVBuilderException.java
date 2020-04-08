package com.bridgelabz.exception;

public class CSVBuilderException extends Exception{

    public enum Exceptiontype {
        ENTERED_WRONG_FILE;
    }
    public Exceptiontype type;

       public CSVBuilderException(Exceptiontype type, String message) {
        super(message);
        this.type = type;
    }
}

