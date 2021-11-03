package com.lab2java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Water {

    public static int water(String s) {
        if(s.indexOf("/") == 0){
            if(s.contains("[")){
                return 1;
            }else{
                return 2;
            }
        }else{
            return 3;
        }

    }


    public static void var1(String s,StringBuilder sb){
        String[] delimiters = new String[10];
        Pattern pattern = Pattern.compile("\\W");
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(s);//находим совпадения по патерну


        int counter = 0;
        while(m.find()){//находим все совпадения и записывааем в масив

            delimiters[counter] = m.group(1);

           // Matcher matcher = pattern.matcher(delimiters[counter].toString());
            //if(matcher.find()){
              //  System.out.println("Not valid input");
                //System.exit(0);
            //}


            counter++;

        }

        // построение строки для реулярного выражения
        for(int i=0;i<counter;i++){
            if(delimiters[i].contains(".") || delimiters[i].contains("*") || delimiters[i].contains("?")){//проверка на метасимволы
                int templen = delimiters[i].length();//длина делимитра

                for(int a=0;a<templen;a++){
                    sb.append("\\"+delimiters[i].charAt(0));
                }
                sb.append("|");
            }else{
                sb.append(delimiters[i]+"|");

            }
        }

        //убираем ласт |
        sb.deleteCharAt(sb.lastIndexOf("|"));

        Water.resalting(s,sb);

    }




    public static void var2(String s,StringBuilder sb){
        String delimiter = Character.toString(s.charAt(2));//выбираем 3 символ
        if(delimiter.contains(".") || delimiter.contains("*") || delimiter.contains("?")){
            sb.append("\\"+ Character.toString(s.charAt(2)));
        }else{
            sb.append(Character.toString(s.charAt(2)));
        }

        resalting(s,sb);

    }

    public static void var3(String s,StringBuilder sb){
        sb.append(",");
        resalting(s,sb);

    }






    public static void resalting(String s,StringBuilder sb){
        int res = 0;
        s = s.substring(s.indexOf("n")+1,s.length());// delete first elements
        String[] ss = s.split(sb.toString());//spitting by string by regex


        for(int i=0;i<ss.length;i++){
            int strtoint = 0;


            try{
                if(ss[i] == ""){
                    continue;
                }
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
                System.exit(0);
            }

        }

        System.out.println("Result : "+ res);

    }
}