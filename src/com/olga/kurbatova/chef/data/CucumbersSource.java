package com.olga.kurbatova.chef.data;

import com.olga.kurbatova.chef.products.vegetable.Cucumber;

import java.util.ArrayList;

//CucumbersSource - общий интерфейс-источник данных для метода класса ReadManager.
//Создаем, чтоб не создавать два одинаковых метода в ReadManager
public interface CucumbersSource {
    ArrayList<Cucumber> getCucumbers();
//имя источника данных(либо БД, либо ХМL)
    String getSourceName();
}
