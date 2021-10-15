package com.company;
import com.company.Cal1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Write a string : ");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        Cal1.Add(str);

    }
}
