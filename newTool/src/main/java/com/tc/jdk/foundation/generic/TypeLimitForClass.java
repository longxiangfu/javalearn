package com.tc.jdk.foundation.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型类型限定-类
 * 使用extends关键字，关键字后面跟类和接口，类在前面，接口在后面，中间用&相连，如<T extends ArrayList & Comparable & Serializable>
 */
public class TypeLimitForClass<T extends List & Serializable> {
    private T data;

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        TypeLimitForClass<ArrayList> typeLimitForClass = new TypeLimitForClass<>();
        typeLimitForClass.setData(list);
        TypeLimitForClass<ArrayList> typeLimitForClass1 = new TypeLimitForClass<>();
        typeLimitForClass1.setData(list1);
//        TypeLimitForClass<String> typeLimitForClass2 = new TypeLimitForClass<>(); // 报错

        System.out.println(getMin(typeLimitForClass.getData().size(), typeLimitForClass1.getData().size()));

    }


    /**
     * <T extends Comparable<T>>  类型T必须实现Comparable接口，并且这个接口的类型是T
     * <T extends Comparable<? super T>>  类型T必须实现Comparable接口，并且这个接口的类型是T或T的任一父类
     * <T extends Comparable<? extend T>>  类型T必须实现Comparable接口，并且这个接口的类型是T或T的任一子类
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static  <T extends Comparable<T>> T getMin(T a, T b){
        return (a.compareTo(b)<0) ? a : b;
    }
}
