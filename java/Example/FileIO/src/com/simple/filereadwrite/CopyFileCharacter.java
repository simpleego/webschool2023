package com.simple.filereadwrite;

import java.io.*;

public class CopyFileCharacter {
    public static void main(String[] args) throws IOException {

        FileReader in = null;
        FileWriter out = null;
        int c;

        String inFileName = args[0]; //"input.txt";
        String outFileName = args[1]; //"out1.txt";
        System.out.println("원본 파일명:"+inFileName);
        System.out.println("사본 파일명:"+outFileName);
        int count=0;
        try {
            in = new FileReader(inFileName);
            out = new FileWriter(outFileName);
            while ((c = in.read()) != -1){
                if(c == '가'){
                    count++;
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
