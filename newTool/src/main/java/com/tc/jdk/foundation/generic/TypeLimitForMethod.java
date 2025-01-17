package com.tc.jdk.foundation.generic;

/**
 * 泛型类型限定-方法
 * <T extends Comparable<T>>  类型T必须实现Comparable接口，并且这个接口的类型是T
 * <T extends Comparable<? super T>>  类型T必须实现Comparable接口，并且这个接口的类型是T或T的任一父类
 * <T extends Comparable<? extend T>>  类型T必须实现Comparable接口，并且这个接口的类型是T或T的任一子类
 * */
public class TypeLimitForMethod {

    private static <T extends Comparable> T getMin(T a, T b){
        return (a.compareTo(b)<0) ? a : b;
    }
    

    public static void main(String[] args) {
        System.out.println(TypeLimitForMethod.getMin(1, 2));
        System.out.println(TypeLimitForMethod.getMin("a", "r"));
    }
}
