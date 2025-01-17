package com.tc.hutoolTest.language;

import cn.hutool.core.lang.Singleton;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Singleton  获取单例
 * 通过ConcurrentHashMap来实现，是线程安全的
 */
public class SingletonDemoTest {
    public static interface Animal {
        public void say();
    }

    public static class Dog implements Animal {

        @Override
        public void say() {
            System.out.println("汪汪");
        }
    }

    public static class Cat implements Animal {

        @Override
        public void say() {
            System.out.println("喵喵");
        }
    }

    public static void main(String[] args) {
        Dog dog = Singleton.get(Dog.class);
        Cat cat = Singleton.get(Cat.class);
        System.out.println(dog == Singleton.get(Dog.class)); // true
        System.out.println(cat == Singleton.get(Cat.class)); // true
        dog.say(); // 汪汪
        cat.say(); // 喵喵
    }
}
