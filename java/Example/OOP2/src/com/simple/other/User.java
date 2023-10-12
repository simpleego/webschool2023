package com.simple.other;

import com.simple.oop2.AccessControl;
import java.util.Calendar;

public class User {
    String id="simple123";
    String password="1234";
    String email = "simple@simple.com";

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" +  '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        AccessControl other = new AccessControl();
        //Math.random();
        //Calendar.getInstance();
        //other.addr = "서울시 강서구 123";

        //other.showInfo();

    }
}
