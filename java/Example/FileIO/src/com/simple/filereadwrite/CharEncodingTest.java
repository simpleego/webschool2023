package com.simple.filereadwrite;

import java.io.*;

public class CharEncodingTest {
    public static void main(String[] args) throws IOException {

        File fileDir = new File("input5.txt");
        System.out.println(fileDir);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileDir), "UTF8"));

        String str;

        while ( (str = in.readLine()) != null) {
            System.out.println(str);
        }
    }
}
