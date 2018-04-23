package com.olga.kurbatova.chef.products;

import com.olga.kurbatova.chef.products.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
//Компоратор используется в методе Collections.sort для сортировки коллекции продуктов по заданному параметру
    private int typeOfSort;

    public static final int PRICE = 0;
    public static final int CALORIES = 1;
    public static final int WEIGHT = 2;
    public static final int NAME = 3;

    public ProductComparator(int typeOfSort) {
        this.typeOfSort = typeOfSort;
    }

    @Override
    //вернет отрицательное число, если product1<product2, или 0, если они равны
    public int compare(Product product1, Product product2) {
        if (typeOfSort == PRICE) {
            return (int) (product1.getPrice() - product2.getPrice());
        }
        if (typeOfSort == CALORIES) {
            return (int) (product1.getCalories() - product2.getCalories());
        }
        if (typeOfSort == WEIGHT) {
            return (int) (product1.getWeight() - product2.getWeight());
        }
        if (typeOfSort == NAME) {
            return product1.getName().compareTo(product2.getName());
        }

        return 0;
    }
}
