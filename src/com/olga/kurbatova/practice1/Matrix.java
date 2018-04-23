package com.olga.kurbatova.practice1;

import java.util.Random;

public class Matrix {

    public static int[][] transpose(int[][] data) {
        int[][] transposed = new int[data[0].length][data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                transposed[j][i] = data[i][j];
            }
        }
        return transposed;
    }

    public static int[][] getRandomMatrix(int x, int y) {
        int[][] arr = new int[x][y];
        Random r = new Random();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                arr[i][j] = r.nextInt(100);
            }
        }
        return arr;
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}

