package com.simple.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExceptionBasic {

    public void writeList() throws FileNotFoundException {
        PrintWriter  writer = new PrintWriter(new File("out.txt"));
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for(int i=0; i<10; i++){
            array[i] = 0;
        }
        array[0] = 100;
        int divider = 10;
        int mok=0;
        int result=0;

        try {
             mok = array[0]/divider;
        }catch (ArithmeticException e){
            mok = 200;
            //e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("사용한 자원을 해제합니다.");
        }

        try {
            result = array[12];
        }catch (ArithmeticException e){
            result = 100;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("사용한 자원을 해제합니다.");
        }

        System.out.println("몫 : "+mok);
        System.out.println("배열값 : "+result);
    }
}
