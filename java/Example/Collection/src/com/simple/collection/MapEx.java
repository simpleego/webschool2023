package com.simple.collection;

import java.util.HashMap;
import java.util.Map;

class Student {
    int number;
    String name;

    public Student(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}

public class MapEx {

    public static void main(String[] args) {

        Map<String, Student> student = new HashMap<>();

        student.put("20090001",new Student(20090001,"구준표"));
        student.put("20090002",new Student(20090002,"홍길동"));
        student.put("20090003",new Student(20090003,"김길동"));
        student.put("20090003",new Student(20090003,"윤지후"));
        student.put("20090004",new Student(20090004,"김준표"));
        student.put("20090005",new Student(20090005,"이순신"));
        student.put("20090006",new Student(20090006,"강감찬"));

        // Map 출력
        System.out.println(student);
        student.remove("20090002");
        System.out.println(student);
        student.put("20090003",new Student(20090003,"소이정"));
        System.out.println(student.get("20090001"));
        for(Map.Entry<String,Student> s : student.entrySet()){
            String key = s.getKey();
            Student value = s.getValue();
            System.out.println("key :"+key+ " Value : "+value);
        }

    }

}
