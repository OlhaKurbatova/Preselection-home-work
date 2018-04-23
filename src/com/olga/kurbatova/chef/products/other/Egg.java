package com.olga.kurbatova.chef.products.other;

import com.olga.kurbatova.chef.products.Product;
//класс яйцо необходим для демонстрации работы полиморфизма за счет интерфейса и для NotVeganFoodExeption

public class Egg implements Product {

    private String name;
    private double caloricity;
    private double weight;
    private double price;

   public Egg(double weight) {
        this.caloricity = 150;
        this.weight = weight;
        this.name = "Egg";
        this.price = 25;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getCalories() {
        return caloricity;
    }


}
