package com.olga.kurbatova.chef.salad;

import com.olga.kurbatova.chef.products.Product;

import java.util.ArrayList;

public class SaladFilter {
    boolean isModified = false;
    private double priceMin = Double.MIN_VALUE;
    private double priceMax = Double.MAX_VALUE;
    private double caloriesMin = Double.MIN_VALUE;
    private double caloriesMax = Double.MAX_VALUE;
    private double weightMin = Double.MIN_VALUE;
    private double weightMax = Double.MAX_VALUE;

    public void setPriceMin(double priceMin) {
        this.priceMin = priceMin;
        isModified = true;
    }

    public void setPriceMax(double priceMax) {
        this.priceMax = priceMax;
        isModified = true;
    }

    public void setCaloriesMin(double caloriesMin) {
        this.caloriesMin = caloriesMin;
        isModified = true;
    }

    public void setCaloriesMax(double caloriesMax) {
        this.caloriesMax = caloriesMax;
        isModified = true;
    }

    public void setWeightMin(double weightMin) {
        this.weightMin = weightMin;
        isModified = true;
    }

    public void setWeightMax(double weightMax) {
        this.weightMax = weightMax;
        isModified = true;
    }
    ArrayList<Product> filter(ArrayList<Product> originSaladList) {

        if (!isModified) {
            throw new IllegalStateException("At least one filter must be set");
        }
        ArrayList<Product> filteredSaladList = new ArrayList<>();
        for (int i = 0; i < originSaladList.size(); i++) {
            Product currentProduct = originSaladList.get(i);
            boolean isMatchesCaloriesFilter =
                    currentProduct.getCalories() >= caloriesMin &&
                            currentProduct.getCalories() <= caloriesMax;
            boolean isMatchesWeightFilter =
                    currentProduct.getWeight() >= weightMin &&
                            currentProduct.getWeight() <= weightMax;
            boolean isMatchesPrice =
                    currentProduct.getPrice() >= priceMin &&
                            currentProduct.getPrice() <= priceMax;

            if (isMatchesCaloriesFilter && isMatchesPrice && isMatchesWeightFilter) {
                filteredSaladList.add(currentProduct);
            }
        }
        return filteredSaladList;
    }

}
