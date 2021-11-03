package com.lab2java;

import java.util.Scanner;

public class Minus {
    public static void Minus(String str) {

        if(str.contains("-") == true) {
            System.out.println("\nВы ввели отрицательные числа ");

            String [] minus = str.split("(?=-)|\\D");
            for(int a=0;a<minus.length;a++) {
                if(minus[a].contains("-")){
                    System.out.println(minus[a]);
                }

            }
            System. exit(0);

        }

    }
}
