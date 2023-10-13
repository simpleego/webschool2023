package com.simple.sungjuk;

public class Sungjuk {
    private String name;
    private String deptCode;
    private boolean gender;

    private int kor,eng,mat;

    private int tot;
    private double average;
    private String grade;

    // 생성자
    public Sungjuk(){
        this("홍길동","202301001",true,0,0,0);
    }
    public Sungjuk(int kor, int eng, int mat) {
        this("홍길동","202301001",true,kor,eng,mat);
    }
    public Sungjuk(String name, String deptCode, boolean gender) {
        this(name,deptCode,gender,0,0,0);
    }

    public Sungjuk(String name, String deptCode, boolean gender, int kor, int eng, int mat) {
        this.name = name;
        this.deptCode = deptCode;
        this.gender = gender;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    // Getter, Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getKor() {
        return kor;
    }
    public void setKor(int kor) {
        if(kor < 0 || kor > 100) {
            this.kor = 0;
        }else {
            this.kor = kor;
        }
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        if(eng < 0 || eng > 100) {
            this.eng = 0;
        }else{
           this.eng = eng;
        }
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        if(mat < 0 || mat > 100) {
            this.mat = 0;
        }else {
            this.mat = mat;
        }
    }

    public int getTot() {
        return calcTotal();
    }

    private int calcTotal(){
        return kor+eng+mat;
    }
    private double calcAverage(){
        return (double) calcTotal() / 3;
    }
    public void setTot() {
        this.tot = calcTotal();
    }

    public double getAverage() {
        return calcAverage();
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // ToString
    @Override
    public String toString() {
        return "성적{" +
                "이름='" + name + '\'' +
                ", 학번='" + deptCode + '\'' +
                ", 성별:" + gender +
                ", 국어=" + kor +
                ", 영어=" + eng +
                ", 수학=" + mat +
                ", 총점=" + tot +
                ", 평균=" + average +
                ", 학점='" + grade + '\'' +
                '}';
    }
}
