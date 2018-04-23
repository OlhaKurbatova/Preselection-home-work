package com.olga.kurbatova.chef;

import com.olga.kurbatova.chef.data.DBManager;
import com.olga.kurbatova.chef.data.ReadManager;
import com.olga.kurbatova.chef.data.XMLManager;
import com.olga.kurbatova.chef.exceptions.TooMuchCaloriesException;
import com.olga.kurbatova.chef.products.other.Egg;
import com.olga.kurbatova.chef.products.vegetable.Cucumber;
import com.olga.kurbatova.chef.products.vegetable.Potato;
import com.olga.kurbatova.chef.products.vegetable.Tomato;
import com.olga.kurbatova.chef.salad.DietSalad;
import com.olga.kurbatova.chef.salad.SaladFilter;


import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        /*класс DietSalad необходим для демонстрации эксепшена,
        т.к. в нем стоит ограничение на суммарную калорийность салата.
        При попытке добавить продукт,
        который эту сумму будет превышать, он кинет TooMuchCaloriesException.*/
        DietSalad mySalad = new DietSalad();
        try {
            mySalad.addProduct(new Cucumber(100, "USA", false));
            mySalad.addProduct(new Tomato(50, "Ukraine", true));
            mySalad.addProduct(new Potato(200, "Ukraine", true));
            mySalad.addProduct(new Egg(150));
        } catch (TooMuchCaloriesException e) {
            System.out.println(e.getMessage());
        }
        //печатаем калорийность салата
        System.out.println("Salad calorycity: " + mySalad.getSaladCalorycity());

        //Чтение из файла
        TxtFileReader.readFile();
        //Запись в файл рецепта салата: имя+калорийность
        try {
            TxtFileReader.writeToFile(mySalad.getRecipe(), "salad");
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Фильтрация
        SaladFilter mySaladFilter = new SaladFilter();
        //фильтруем салат по максимальной калорийности и минимальной цене.
        mySaladFilter.setCaloriesMax(160);
        mySaladFilter.setPriceMin(1);
        mySalad.filter(mySaladFilter);
        //записываем отфильтрованный салат в файл
        try {
            TxtFileReader.writeToFile(mySalad.getRecipe(), "filteredSalad");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*считать данные из БД и распечатать. Распечатать появиться возможность только если включен mySQLServer
        и раскоментирована строка 64 manager.readAndPrintData(new DBManager());
         */
        ReadManager manager = new ReadManager();
       // manager.readAndPrintData(new DBManager());

        //считать данные из XML и распечатать
        manager.readAndPrintData(new XMLManager());
    }
}
