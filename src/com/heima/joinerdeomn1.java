package com.heima;

import java.util.StringJoiner;

/**
 * @Auther cxg
 * @DAte 2023/10/17
 */
public class joinerdeomn1 {
    public static void main(String[] args) {
        StringJoiner sj=new StringJoiner(",","[","]");
        String str1="bac";
        String str2="jei";
        sj.add(str2);
        sj.add(str1);
        System.out.println(sj);

    }
}
