package com.company;

//метод 1 и 2  (калькулятор для строки по типу \\д*,\\д* для любого колическва чисел и с любым разделителем)

public class Cal1 {
    public static void Add(String str){

        int res = 0;

        if(str.matches("^([0-9]*+(,*|(\\n)*)?)*$") == false){
            System.out.println("Ваш ввод был неправельным ");
        }else{
            String[] value = str.split("\\D+");
            for(int i=0;i<value.length;i++){
                int strtoint = 0;
                try{
                    strtoint = Integer.parseInt(value[i]);  //делает из типа стр тип инт
                    res+=strtoint;
                }catch (NumberFormatException e){
                }
            }

            System.out.println(res);

        }
    }
}
