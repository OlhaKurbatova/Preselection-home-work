package com.olga.kurbatova.chef.exceptions;

public class NotVeganFoodException extends SaladCreatingException {
    //кидаем в случае, если в салат попытаются добавить не овощ
    public  NotVeganFoodException(String message)

    {super(message);}
}
