package com.simple.exception;

import java.io.IOException;

public class ExceptionBasic2 {

    public static void main(String[] args) {
        try{
            System.out.println(readString());
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static String readString() throws IOException {
        byte[]buf = new byte[100];
        System.out.println("문자열을 입력하시오");
        System.in.read(buf);
        return new String(buf);
    }
}
