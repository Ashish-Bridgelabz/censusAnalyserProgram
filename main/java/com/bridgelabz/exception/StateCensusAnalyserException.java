package com.bridgelabz.exception;

public class StateCensusAnalyserException extends Exception {
    public enum Exceptiontype {
        ENTERED_WRONG_FILE,ENTER_WRONG_FILE_TYPE,ENTERED_INCORRECT_DELIMITER;
    }

    public Exceptiontype type;

    public StateCensusAnalyserException(Exceptiontype type, String message) {
        super(message);
        this.type = type;
    }
}

