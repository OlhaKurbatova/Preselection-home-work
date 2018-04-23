package com.olga.kurbatova.chef.products.vegetable;

public class Cucumber extends Vegetable {
    //создаем частично предопределенный системой огурец
    public Cucumber(double weight, String country, boolean isNative) {
        super(20, weight, 11,"USA_Cucumber", country, isNative);
    }
    //этот конуструктор нужен для DB и XMLManager, для создания объектов при считывании данных.
    public Cucumber(double caloricity, double weight, double price, String name, String country, boolean isNative) {
        super(caloricity, weight, price,name, country, isNative);
    }}
