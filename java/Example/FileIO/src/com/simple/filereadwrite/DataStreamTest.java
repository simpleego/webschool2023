package com.simple.filereadwrite;

import java.io.*;

public class DataStreamTest {
    public static void main(String[] args) throws IOException {
        DataInputStream in = null;
        DataOutputStream out = null;

        out = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("data2.bin"),10));
        out.writeInt(200000000);
        out.writeChar('가');
        out.writeByte(123);
        out.writeUTF("자신의 생각을 바꾸지 못하는 사람은 결코 현실을 바꿀 수 없다.");
        //out.flush();
        in = new DataInputStream(new BufferedInputStream(
                new FileInputStream("data2.bin")));

        //char ch = in.readChar();
        System.out.println(in.readInt());
        System.out.println(in.readChar());
        System.out.println(in.readByte());
        System.out.println(in.readUTF());
    }
}
