package com.tc.jdk.foundation.generic;

public class GenericMethod2 {
    static class Animal{
        @Override
        public String toString() {
            return "Animal{}";
        }
    }
    static class Dog extends Animal{
        @Override
        public String toString() {
            return "Dog{}";
        }
    }
    static class Fruit{
        @Override
        public String toString() {
            return "Fruit{}";
        }
    }

    static class GenericClass<T>{
        /**
         * 并不是泛型方法，属于泛型类的普通方法
         * @param t
         */
        public void show01(T t){
            System.out.println(t.toString());
        }

        /**
         * 泛型方法
         * @param t
         * @param <T>
         */
        public <T> void show02(T t){
            System.out.println(t.toString());
        }

    }


    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Fruit fruit = new Fruit();

        //泛型类在初始化时，限定了参数类型
//        GenericClass<Animal> genericClass = new GenericClass<>();
//        genericClass.show01(animal); // Animal{}
//        genericClass.show01(dog); // Dog{}

        // 在使用时指定
//        GenericClass genericClass = new GenericClass<>();
//        genericClass.show02(animal); // Animal{}
//        genericClass.show02(dog); // Dog{}
//        genericClass.show02(fruit); // Fruit{}

    }

}
