package com.heima;

import java.util.ArrayList;

/**
 * @Auther cxg
 * @DAte 2023/10/17
 */
public class ArrayListdemon {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.set(1,"lkkk");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            String str=list.get(i);
            System.out.println(str);
        }
    }
}
