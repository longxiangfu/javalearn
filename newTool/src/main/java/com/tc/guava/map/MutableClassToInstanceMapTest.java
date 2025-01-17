package com.tc.guava.map;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * 实例Map<Class, 实例对象>
 */
public class MutableClassToInstanceMapTest {
    public static void main(String[] args) {
        ClassToInstanceMap<Object> instanceMap = MutableClassToInstanceMap.create();
        instanceMap.putInstance(User.class, new User());
        instanceMap.putInstance(Dept.class, new Dept());

        User user = instanceMap.getInstance(User.class);
        System.out.println(user); // User(id=null, name=null)
    }
}
