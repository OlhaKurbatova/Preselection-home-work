package com.olga.kurbatova.practice1;

import java.util.Scanner;

import static com.olga.kurbatova.practice1.Matrix.*;

public class Activator {

    public static void main(String[] args) {
        String operation;

        boolean needContinue = true;
        CalcFunctions calc = new CalcFunctions();

        while (needContinue) {
            System.out.println("Choose needed option: +,-,*,/,trnsps, exit");

            Scanner in = new Scanner(System.in);
            operation = in.nextLine();
            if (operation.equals("exit") ||
                    operation.equals("+") ||
                    operation.equals("-") ||
                    operation.equals("*") ||
                    operation.equals("/") ||
                    operation.equals("trnsps")) {

                if (operation.equals("exit")) {
                    needContinue = false;
                    System.out.println("Good bye!");
                } else {
                    System.out.print("a=");
                    double a = Double.parseDouble(in.nextLine());
                    System.out.print("b=");
                    double b = Double.parseDouble(in.nextLine());
                    if (operation.equals("+")) {
                        double result = calc.plus(a, b);
                        System.out.println("a+b=" + result);
                    }
                    if (operation.equals("-")) {
                        double result = calc.minus(a, b);
                        System.out.println("a-b=" + result);
                    }
                    if (operation.equals("/")) {
                        double result = calc.devide(a, b);
                        System.out.println("a+b=" + result);
                    }
                    if (operation.equals("*")) {
                        double result = calc.mult(a, b);
                        System.out.println("a*b=" + result);
                    }
                    if (operation.equals("trnsps")) {
                        int[][] data = getRandomMatrix((int)a, (int)b);
                        printMatrix(data);
                        data = transpose(data);
                        printMatrix(data);
                    }
                }
            } else System.out.println("Incorrect symbol, please, try again");
        }
    }

}
