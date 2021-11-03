package com.lab2java;
import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.lang.*;

public class Main {
    public static void main(String[] arg){
        //gg();
        //String s = "//[***][**][;]\\n1***2**3;4";
        //String s = "//;\\n1;2;3;4"
        System.out.println("Write a string : ");
        Scanner scamer = new Scanner(System.in);
        String s = scamer.nextLine();


        //int res =0;
        //String[] delimiters = new String[10];

        StringBuilder sb = new StringBuilder();
        sb.append("\\\\n|");


        if(Water.water(s) == 1){
            Water.var1(s,sb);
        }else if(Water.water(s) == 2){
            Water.var2(s,sb);
        }else if(Water.water(s) == 3){
            Water.var3(s,sb);
        }else{
            System.out.println("Not valid input");
            System.exit(0);
        }

        System.exit(0);






















        String[] delimiters = new String[10];
        int res =0;

        if(s.indexOf("/") == 0){
            if(s.contains("[") == true){

                Pattern p = Pattern.compile("\\[(.*?)\\]");
                Matcher m = p.matcher(s);

                //int counter = 0;

                //StringBuilder sb = new StringBuilder();
                //sb.append("\\n|");

                int counter = 0;
                while(m.find()){

                    delimiters[counter] = m.group(1);
                    counter++;

                }


                // делаем строку как регекс и вталяем в копилятор разделителя
                for(int i=0;i<counter;i++){
                    if(delimiters[i].contains(".") || delimiters[i].contains("*") || delimiters[i].contains("?")){
                        int templen = delimiters[i].length();
                        //String tempstr = delimiters[counter];
                        for(int a=0;a<templen;a++){
                            sb.append("\\"+delimiters[i].charAt(0));
                        }
                        sb.append("|");
                    }else{
                        sb.append("\\"+delimiters[i]+"|");

                    }
                }

                //убираем ласт |
                sb.deleteCharAt(sb.lastIndexOf("|"));
                System.out.println(sb.toString());// regex to string

                //Pattern pattern = Pattern.compile(sb.toString());

                s = s.substring(s.indexOf("n")+1,s.length());// delete first elements
                String[] ss = s.split(sb.toString());//spitting by string by regex

                for(int i=0;i<ss.length;i++){
                    int strtoint = 0;
                    try{
                        strtoint = Integer.parseInt(ss[i]);  //делает из типа стр тип инт

                        if(strtoint>1000){
                            strtoint = 0;
                        }else if(strtoint <0){
                            Minus.Minus(s);
                        }else{
                            res+=strtoint;
                        }


                        //res+=strtoint;
                    }catch (NumberFormatException e){
                        System.out.println("Not valid input");
                        break;

                    }


                   // System.out.println(ss[i]);
                }

                System.out.println(res);




            }else{

                String delimiter = Character.toString(s.charAt(2));//выбираем 3 символ
                if(delimiter.contains(".") || delimiter.contains("*") || delimiter.contains("?")){
                    sb.append("\\"+ Character.toString(s.charAt(2)));
                }else{
                    sb.append(Character.toString(s.charAt(2)));
                }

                s = s.substring(s.indexOf("n")+1,s.length());// убираем все до числа
                String[] ss = s.split(Pattern.quote(delimiter));//делим за делиминтром

                for(int i=0;i<ss.length;i++){

                    int strtoint = 0;
                    try{
                        strtoint = Integer.parseInt(ss[i]);  //делает из типа стр тип инт

                        if(strtoint>1000){
                            strtoint = 0;
                        }else if(strtoint <0){
                            Minus.Minus(s);
                        }else{
                            res+=strtoint;
                        }

                    }catch (NumberFormatException e){
                        System.out.println("Not valid input");
                        break;
                    }

                }
                System.out.println(res);
            }


        }else{
            System.out.println("nihao");

        }

    }

    public static void gg(){
        String s = "//[**][%]\\n1**2%3";
        String[] ss = s.split("\\*|%|\\\\n|");
        for(int i=0;i<ss.length;i++){
            System.out.println(ss[i]);
        }
    }
}
