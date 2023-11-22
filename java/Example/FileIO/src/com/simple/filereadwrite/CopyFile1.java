package com.simple.filereadwrite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile1 {
    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;
        int c;

        String inFileName = args[0]; //"input.txt";
        String outFileName = args[1]; //"out1.txt";
        System.out.println("원본 파일명:"+inFileName);
        System.out.println("사본 파일명:"+outFileName);
        int count=0;
        try {
            in = new FileInputStream(inFileName);
            out = new FileOutputStream(outFileName);
            while ((c = in.read()) != -1){
                if(c >= 65 && c<=90){
                    count++;
                    c=c+32;
                }
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(in != null)
                in.close();
            if(out != null)
                out.close();
        }
        System.out.println("점의 개수: "+count);
    }
}
