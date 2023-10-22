package com.heima;

/**
 * @Auther cxg
 * @DAte 2023/10/17
 */
public class roratedemon {
    public static void main(String[] args) {
        String str1="abcd";
        String str2="cdab" ;
        System.out.println(check(str1,str2));
    }
    public static Boolean check(String str1,String str2){
        for(int i=0;i<str1.length();i++){
            str1=rorate(str1);
            if(str1.equals(str2))
                return true;
        }
        return false;
    }

    public static String rorate(String str){
        char []arr=str.toCharArray();
        char first=arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=first;
        String str2=new String(arr);
        return str2;
    }
}
