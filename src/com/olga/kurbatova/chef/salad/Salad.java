package com.olga.kurbatova.chef.salad;

import com.olga.kurbatova.chef.exceptions.SaladCreatingException;
import com.olga.kurbatova.chef.products.Product;
import com.olga.kurbatova.chef.products.ProductComparator;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Salad {
    //коллекция продуктов
    protected ArrayList<Product> products = new ArrayList();

    public void addProduct(Product product) throws SaladCreatingException {
        products.add(product);
    }

    //считаем калорийнось салата
    public double getSaladCaloricity() {
        //создать цикл, в цикле пройтись по коллекции, посчитать калорийность всех продуктовсалата
        int i = 0;
        double calorycitySum = 0;

        for (i = 0; i < products.size(); i++) {
            calorycitySum += products.get(i).getCalories();
        }

        return calorycitySum;
    }

    //Сортировки по параметрам продукта
    public void sortByPrice() {
        Collections.sort(products, new ProductComparator(ProductComparator.PRICE));
    }

    public void sortByCalories() {
        Collections.sort(products, new ProductComparator(ProductComparator.CALORIES));
    }

    public void sortByWeight() {
        Collections.sort(products, new ProductComparator(ProductComparator.WEIGHT));
    }

    public void sortByName() {
        Collections.sort(products, new ProductComparator(ProductComparator.NAME));
    }


    //получение строки для записи в файл
    public String getRecipe() {
        String recipe = "";
        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getName();
            String weight = String.valueOf(products.get(i).getWeight());
            recipe += name + " " + weight + "\n";
        }

        return recipe;
    }

    public void print() {
        for (Product p : products) {
            System.out.println(p.getName() + ", price = " + p.getPrice() + ", weight = " + p.getWeight() + ", calories = " + p.getCalories());
        }
        System.out.println();
    }

    //фильтрация салата
    public void filter(SaladFilter saladFilter) {
        products = saladFilter.filter(products);
    }

}
