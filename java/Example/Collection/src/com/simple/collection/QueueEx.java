package com.simple.collection;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueEx {

    public static void main(String[] args) throws InterruptedException {
        int time=5;
        //Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(10);
        pq.add(80);
        pq.add(80);
        pq.add(20);

        for (Integer o : pq) {
            System.out.println(o);
        }

        System.out.println("원소 삭제(출력)");
        while (!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }

}
