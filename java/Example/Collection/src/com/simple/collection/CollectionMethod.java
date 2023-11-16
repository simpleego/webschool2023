package com.simple.collection;

import java.util.*;

public class CollectionMethod {

    public static void main(String[] args) {
        String[] sample={"i","walk","the","line"};
        List<String> list = Arrays.asList(sample);
        int key=4;
        List<Integer> listNum = new ArrayList<>();
        for(int i=0; i<10; i++){
            int num = (int)(Math.random()*10);
            listNum.add(num);
        }
        Collections.sort(listNum);
        System.out.println(listNum);

        int index = Collections.binarySearch(listNum,key);
        System.out.println("위치:"+index);
    }

}
