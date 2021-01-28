package com.ssafy;

public class GenericContainer<T> {
    private T obj;

    public GenericContainer(){}

    public T getObj() { return obj; }

    public void setObj(T t) { obj = t; }
}
