package com.olga.kurbatova.chef.data;

import com.olga.kurbatova.chef.products.vegetable.Cucumber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager implements CucumbersSource {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/vegetables_schema";
    private static final String user = "root";
    private static final String password = "root";

    //create conn
    //считать данные из бд
      public ArrayList<Cucumber> getCucumbersFromDb() {
        try {//загрузка класса драйвера в память
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("no driver found");
        }
        // opening database connection to MySQL server
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // JDBC variables for opening and managing connection
            Statement stmt;
            ResultSet rs;

            ArrayList<Cucumber> cucumbers = new ArrayList<Cucumber>();
            // getting Statement object to execute getCucumbersFromDB
            String query = "select * from Cucumber";
            stmt = conn.createStatement();
            // executing SELECT getCucumbersFromDB
            rs = stmt.executeQuery(query);
            //next изначально указывает на индекс -1, возвращает true если есть что-то дальше и сдвигается вправо на 1
            while (rs.next()) {
                String name = rs.getString("Name");
                Double weight = rs.getDouble("Weight");
                Double caloricity = rs.getDouble("Caloricity");
                double price = rs.getDouble("Price");
                String country = rs.getString("Country");
                Boolean isNative;
                if (country.equalsIgnoreCase("Ukraine")) {
                    isNative = true;
                } else isNative = false;

                Cucumber cucumber = new Cucumber(caloricity, weight, price, name, country, isNative);
                cucumbers.add(cucumber);
            }
            return cucumbers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//@Override - аннотация, которая показывает, что метод переопределен. (методы интерфейса CucumberSource
    @Override
    public ArrayList<Cucumber> getCucumbers() {
        return getCucumbersFromDb();
    }

    @Override
    public String getSourceName() {
        return "DB";
    }
}
