package com.olga.kurbatova.chef.products.vegetable;

public interface VeganFood {
    //это интрефейс-маркер. Он нужен для NotVeganFoodException. Если попытаться добавить в Салат класс, который не
    //реализует этот интерфейс, то салат кинет NotVeganFoodException
}
