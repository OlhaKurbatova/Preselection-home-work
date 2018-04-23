package com.olga.kurbatova.chef.exceptions;

public class SaladCreatingException extends Exception {
    //общий предок ексепшенов. Что-то, что может пойти не так во время создания салата.
    public SaladCreatingException(String message) {
        super(message);
    }
}
