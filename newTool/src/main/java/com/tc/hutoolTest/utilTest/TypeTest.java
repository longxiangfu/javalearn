package com.tc.hutoolTest.utilTest;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.TypeUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TypeTest {
    public static void main(String[] args) {
        /**
         * getClass
         */
//        System.out.println(TypeUtil.getClass(TestClass.class).getSimpleName()); // TestClass

        /**
         * TypeUtil.getParamType
         * TypeUtil.getReturnType
         */
//        Method intTest = ReflectUtil.getMethod(TestClass.class, "intTest", Integer.class);
//        System.out.println(TypeUtil.getParamType(intTest, 0)); // class java.lang.Integer
//        System.out.println(TypeUtil.getReturnType(intTest)); //class java.lang.Integer

        /**
         * 获取类的泛型参数
         * public List<String> getList(){
         *         return new ArrayList<>();
         *     }
         */
        Method getList = ReflectUtil.getMethod(TestClass.class, "getList");
        Type returnType = TypeUtil.getReturnType(getList);
        System.out.println(TypeUtil.getTypeArgument(returnType));

    }
}
