package com.olga.kurbatova.chef.salad;

import com.olga.kurbatova.chef.exceptions.NotVeganFoodException;
import com.olga.kurbatova.chef.exceptions.TooMuchCaloriesException;
import com.olga.kurbatova.chef.products.Product;
import com.olga.kurbatova.chef.products.vegetable.VeganFood;

//салат, общая калорийность которого не должна превышать 200 калорий. Если превышает, то сработает ексепшн
public class DietSalad extends Salad {
    public static final double DIET_CALORIES_MAX = 200;

    @Override
    public void addProduct(Product product) throws TooMuchCaloriesException {
        if (getSaladCalorycity() + product.getCalories() < DIET_CALORIES_MAX)//
        {
            products.add(product);
        } else {
            throw new TooMuchCaloriesException("Too much calories. Max is 200");
        }
    }
}
