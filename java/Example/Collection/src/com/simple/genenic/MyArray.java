package com.simple.genenic;

public class MyArray {
    public static <T> T getLast(T[] any){
        return any[any.length-1];
    }

    public static void main(String[] args) {
        String[] language = {"C++", "C#", "JAVA"};
        System.out.println(MyArray.getLast(language));

        Integer[] numbers = new Integer[10];
        for (int i=0; i<numbers.length; i++){
            numbers[i] = (int)(Math.random()*45);
        }
        for (int i=0; i<numbers.length; i++){
            System.out.print(numbers[i]+" ");
        }

        int num = MyArray.getLast(numbers);
        System.out.println("==>"+num);
    }
}
