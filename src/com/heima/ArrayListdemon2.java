package com.heima;

import java.util.ArrayList;

/**
 * @Auther cxg
 * @DAte 2023/10/17
 */
public class ArrayListdemon2 {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            int a=list.get(i);
            if(i==list.size()-1){
                System.out.print(a);
            }
            else{
                System.out.print(a+",");
            }

        }
        System.out.println("]");
    }
}
