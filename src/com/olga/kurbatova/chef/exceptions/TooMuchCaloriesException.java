package com.olga.kurbatova.chef.exceptions;

public class TooMuchCaloriesException extends  SaladCreatingException {
    //кидаем если салат слишком калорийный
    public TooMuchCaloriesException(String message)
    {super(message);}
}
