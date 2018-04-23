package com.olga.kurbatova.chef.data;

import com.olga.kurbatova.chef.products.vegetable.Cucumber;

import java.util.ArrayList;

public class ReadManager {

    public void readAndPrintData(CucumbersSource cs) {
        ArrayList<Cucumber> cucumbers = cs.getCucumbers();
        System.out.println("Data from " + cs.getSourceName() + ":");
        for (int i = 0; i < cucumbers.size(); i++) {
            Cucumber cucumber = cucumbers.get(i);
            String data = cucumber.getName() + " -Name; " + cucumber.getCalories() + " -Calories; " + cucumber.getPrice() + " -Price; " + cucumber.getWeight() + " -Weight; ";
            System.out.println(data);
        }
    }
}
