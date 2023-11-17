package com.simple.threadex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CountDown implements Runnable {

    CountDownMain main;
    CountDown(CountDownMain main){
        this.main = main;
    }

    volatile boolean suspended = false;
    volatile boolean stopped = false;

    @Override
    public void run() {
        while (!stopped) {
            if (!suspended) {
                for (int i = 60; i >= 0; i--) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    main.label.setText(i + "");
                }
            }
        }

    }

    public void threadStop() {
        stopped = true;
    }

    public void threadStart() {
        main.start();
    }

    public void threadSuspended() {
        suspended = true;
    }

    public void threadResume() {
        suspended = false;
    }
}
