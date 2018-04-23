package com.olga.kurbatova.chef.salad;

import com.olga.kurbatova.chef.exceptions.NotVeganFoodException;
import com.olga.kurbatova.chef.products.Product;
import com.olga.kurbatova.chef.products.vegetable.VeganFood;

public class VeganSalad extends Salad {
    //в этот салат нельзя добавлять яйца, молоко или мясо
    @Override
    public void addProduct(Product product) throws NotVeganFoodException {
        if (product instanceof VeganFood){// проверяем,что ,то, что мы кладе в салат реализует интерфейс VeganFood
            products.add(product);
        } else {
            throw new NotVeganFoodException("Not vegan food");
        }
    }
}
