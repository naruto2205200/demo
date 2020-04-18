package com.example.demo;

/**
 * @author naruto
 * @data 2019/5/7.
 */
public class TryFinallyDemo {

    public static void main(String[] args) {

        System.out.println(returnVal());

    }

    public static String returnVal() {
        String str = "hello";
        try{
            return str;
        }finally {
            str="sssss";
        }
    }
}
