package com.example.demo;

/**
 * @author naruto
 * @data 2019/5/26.
 */
public class InnerClass {

    public InnerClass() {
        this.i=3;
    }

    int i = 1;

    public static void main(String[] args) {
        System.out.println(2<<3);
        String a = new String("aa");
        String b = new String("aa");
        System.out.println(a == b);
        System.out.println(a.equals(b));

//        Integer i1 =2;
//        long l1 = 1;
//        switch (i1) {
//            case 1:
//                break;
//            default:
//                break;
//        }

    }

    public class InnerClass3{

    }
}

class InnerClass2{

}
