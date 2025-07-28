package com.tc.jdk.foundation.generic.tongPeiFu;

import com.tc.jdk.foundation.generic.GenericClass;

/**
 * 泛型通配符：?
 * 1、有限定：? extends     ? super
 * 2、无限定：?
 */
public class GenericByWildcard {

    private static void print(GenericClass<Fruit> fruitGenericClass){
        System.out.println(fruitGenericClass.getData().getClor());
    }
    private static void use(){
        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        Fruit fruit = new Fruit();
        fruitGenericClass.setData(fruit);
        print(fruitGenericClass); // red
        //类型不匹配
//        GenericClass<Orange> orangeGenericClass = new GenericClass<>();
//        print(orangeGenericClass);
    }


    /*
    指定泛型类型的上界,用extends
    ? extends T : 该泛型表示包括T在内的所有子类
     */
    private static void printExtends(GenericClass<? extends Fruit> genericClass){
        System.out.println(genericClass.getData().getClor());
    }
    private static void useExtends(){
        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        Fruit fruit = new Fruit();
        fruitGenericClass.setData(fruit);
        printExtends(fruitGenericClass); // red
        GenericClass<Orange> orangeGenericClass = new GenericClass<>();
        Orange orange = new Orange();
        orangeGenericClass.setData(orange);
        printExtends(orangeGenericClass); // red
        GenericClass<HongFuShi> hongFuShiGenericClass = new GenericClass<>();
        HongFuShi hongFuShi = new HongFuShi();
        hongFuShiGenericClass.setData(hongFuShi);
        printExtends(hongFuShiGenericClass); // red
        // Food超出了上界（Fruit）范围
//        GenericClass<Food> foodGenericClass = new GenericClass<>();
//        printExtends(foodGenericClass);

    }


    /*
    指定泛型类型下界，用super
    ？super T : 该泛型表示包括T在内的所有父类
     */
    private static void printSuper(GenericClass<? super Apple> genericClass){
        System.out.println(genericClass.getData());
    }
    private static void useSuper(){
        //
        GenericClass<Food> foodGenericClass = new GenericClass<>();
        Food food = new Food();
        foodGenericClass.setData(food);
        printSuper(foodGenericClass); // red
        GenericClass<Fruit> fruitGenericClass = new GenericClass<>();
        Fruit fruit = new Fruit();
        fruitGenericClass.setData(fruit);
        printSuper(fruitGenericClass); // red
        GenericClass<Apple> appleGenericClass= new GenericClass<>();
        Apple apple = new Apple();
        appleGenericClass.setData(apple);
        printSuper(appleGenericClass); // red
        //HongFuShi超出了下界Apple
//        GenericClass<HongFuShi> hongFuShiGenericClass = new GenericClass<>();
//        printSuper(hongFuShiGenericClass);

    }


    /*
    无限定的通配符
     */
    private static void printNoLimit(GenericClass<?> genericClass){
        System.out.println(genericClass.getData());
    }
    private static void userNoLimit(){
        //
        GenericClass<Food> foodGenericClass = new GenericClass<>();
        Food food = new Food();
        foodGenericClass.setData(food);
        printNoLimit(foodGenericClass);
        GenericClass<HongFuShi> hongFuShiGenericClass = new GenericClass<>();
        HongFuShi hongFuShi = new HongFuShi();
        hongFuShiGenericClass.setData(hongFuShi);
        printNoLimit(hongFuShiGenericClass);
    }


    public static void main(String[] args) {
        use();
        useExtends();
//        useSuper();
//        userNoLimit();
    }



}
