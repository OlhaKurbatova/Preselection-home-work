package com.olga.kurbatova.chef.products.vegetable;

import com.olga.kurbatova.chef.products.Product;

public abstract class Vegetable implements Product, VeganFood {

    private String name;
    private double caloricity;
    private double weight;
    private double price;
    private String country;

    public Vegetable(double caloricity, double weight, double price, String name, String country, boolean isNative) {
        this.caloricity = caloricity;
        this.weight = weight;
        this.name = name;
        this.country = country;
        if (caloricity <= 0) throw new IllegalArgumentException("caloricity can't be less then 1");
        if (weight <= 0) throw new IllegalArgumentException("weight can't be less then 1");
        if (price < 0) throw new IllegalArgumentException("price can't be less then 1");

        //Если продукт заграничный, его цена в два раза выше
        if (!isNative) {
            this.price = price * 2;
        } else this.price = price;
    }


    @Override
    public String getName() {
        return name + " " + country;
    }

    @Override
    public double getCalories() {
        return caloricity;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
