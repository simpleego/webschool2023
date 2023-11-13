package com.simple.genenic;

public class SimplePair<T, V> {
    private T data1;
    private V data2;

    public SimplePair(T data1, V data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public void setFirst(T data1) {
        this.data1 = data1;
    }

    public void setSecond(V data2) {
        this.data2 = data2;
    }

    public T getData1() {
        return data1;
    }

    public V getData2() {
        return data2;
    }
}
