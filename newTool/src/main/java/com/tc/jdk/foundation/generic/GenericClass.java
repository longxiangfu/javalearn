package com.tc.jdk.foundation.generic;

/**
 * 泛型  T 类型
 */
public class GenericClass<T> {
    private T data;

    public T getData(){
        return this.data;
    }
    public void setData(T data){
        this.data = data;
    }


    public static void main(String[] args) {
        GenericClass<String> genericClass = new GenericClass();
        genericClass.setData("genericClass");
        System.out.println(genericClass.getData()); // genericClass
        GenericClass<Integer> genericClassI = new GenericClass();
        genericClassI.setData(100);
        System.out.println(genericClassI.getData()); // 100
    }

}
