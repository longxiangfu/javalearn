package com.tc.jdk.foundation.generic.application;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Gson库中的泛型使用
 * java.lang.reflect.Type，是所有类型的高级接口
 */
public class GsonGeneric {
    private static final Gson GSON = new Gson();

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            personList.add(new Person("name" + i, 18 + i));
        }
        // Serialization
        String json = GSON.toJson(personList);
        System.out.println(json);
//        [{"name":"name0","age":18},{"name":"name1","age":19},{"name":"name2","age":20},{"name":"name3","age":21},{"name":"name4","age":22}]
        // Deserialization
        Type personType = new TypeToken<List<Person>>(){}.getType();
        List<Person> personList2 = GSON.fromJson(json, personType);
        System.out.println(personList2);
//        [Person{name='name0', age=18}, Person{name='name1', age=19}, Person{name='name2', age=20}, Person{name='name3', age=21}, Person{name='name4', age=22}]

        Person p = new Person("lxf", 35);
        String pJson = GSON.toJson(p);
        System.out.println(pJson); // {"name":"lxf","age":35}
        Person p1 = GSON.fromJson(pJson, Person.class);
        System.out.println(p1); // Person{name='lxf', age=35}
    }
}
