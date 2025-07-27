package com.tc.jdk.jdk_E.Optional;

import java.util.Optional;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/11 18:14
 * @Version 1.0
 **/
public class OptionalDemo {
    public static void main(String[] args){
        /*
        创建Optional
        Optional.offNullable()   值可以为null
        Optional.of()   值不能为null，否则报错
         */
//        Optional<Integer> op1 = Optional.ofNullable(1);
//        Optional<Integer> op2 = Optional.ofNullable(null);
//        System.out.println(op1);//Optional[1]
//        System.out.println(op2);//Optional.empty
//        System.out.println(Optional.of(null)); // 报错

        /*
        Optional.empty():所有null包装成的Optional对象
         */
//        Optional<Integer> opt1 = Optional.ofNullable(null);
//        Optional<Integer> opt2 = Optional.ofNullable(null);
//        System.out.println(opt1 == opt2);//true
//        System.out.println(opt1 == Optional.<Integer>empty());//true
//        Object o1 = Optional.<Integer>empty();
//        Object o2 = Optional.<String>empty();
//        System.out.println(o1 == o2);//true

        /*
        isPresent():判断值是否存在
         */
//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//        System.out.println(optional1.isPresent() == true); // true
//        System.out.println(optional2.isPresent() == true); // false

        /*
        ifPresent(Consumer consumer):如果Optional对象保存的值不是null,则调用Consumer对象，否则不调用
         */
//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//        optional1.ifPresent((a) -> System.out.println(a)); // 1
//        optional2.ifPresent((a) -> System.out.println(a)); // 不会执行

        /*
        orElse(value):如果Optional对象保存的值不是null，则返回原来的值，否则返回value
         */
//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//        System.out.println(optional1.orElse(1000) == 1); // true
//        System.out.println(optional2.orElse(1000) == 1000); // true

        /*
        orElseGet(Supplier supplier):功能与orElse一样，只不过参数是一个对象
         */
//        Optional<Integer> optinal1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//        System.out.println(optinal1.orElseGet(() ->{
//            return 1000;
//        }) == 1); // false
//        System.out.println(optional2.orElseGet(() ->{
//            return 1000;
//        }) == 1); // false

        /*
        orElseThrow():值不存在则抛异常，存在值则返回值
         */
//        Optional<Integer> optional1 = Optional.ofNullable(1);
//        Optional<Integer> optional2 = Optional.ofNullable(null);
//        try {
//            Integer a = optional1.orElseThrow(() ->{throw new IllegalStateException();});
//            System.out.println("optional1:" + a); // optional1:1
//        }catch (Throwable e){
//            e.printStackTrace();
//        }
//
//        try{
//            optional2.orElseThrow(() ->{throw new IllegalStateException();}); // 抛异常
//        }catch (Throwable e){
//                e.printStackTrace();
//        }


        /*
        map(Function):对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
        */
        Optional<Integer> optional1 = Optional.ofNullable(1);
        Optional<Integer> optional2 = Optional.ofNullable(null);
        Optional<String> stringOptional1 = optional1.map(a -> "key" + a);
        Optional<String> stringOptional2 = optional2.map(a -> "key" + a);
        System.out.println(stringOptional1.get()); // key1
        System.out.println(stringOptional2.orElseThrow(RuntimeException::new)); // 抛异常

    }

}
