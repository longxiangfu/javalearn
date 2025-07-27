package com.tc.jdk.javaObject;

/**
 * 运行时常量池若干例子
 * 字符串常量池
 * String a = "abc"  在字符串常量池中创建字符串，返回池内引用
 * String a = new String("abc")  在字符串常量池中创建字符串，用在池外堆内创建字符串，返回池外堆内引用
 * a.intern()  如果常量池中存在则返回常量池的，如果不存在，则堆中一定存在，将堆中的引用放入常量池中，返回的引用指向池内引用，最终指向的是池外堆内的对象
 */
public class RuntimeConstantPoolTest {
    public static void main(String[] args) {
//        String a = "abc";
//        String a1 = a.intern();
//        System.out.println(a == a1); // true

//        String a = new String("abc"); // 引用的是池外堆内
//        String a1 = a.intern(); // 引用的是池内
//        System.out.println(a == a1); // false    引用不同
//        System.out.println(a.equals(a1)); // true   内容相同

//        这段代码演示了字符串常量池与intern()方法的关联机制：
//        s1的创建：new String("he") + new String("llo")在堆中生成新对象"hello"（常量池暂无）
//        s2.intern()行为：首次调用时发现常量池无"hello"，将s1的堆引用存入池中，故s2指向堆中的s1（s1 == s2为true）
//        重复调用intern()：s3直接获取池中已存在的s1引用，故s2 == s3和s1 == s3均为true
//        字面量赋值s4："hello"直接复用池中引用，最终s4与s1指向同一对象（s1 == s4为true）
//        所有==比较结果均为true，验证了常量池引用唯一性。
//        String s1 = new String("he") + new String("llo"); // s1只在堆内，不存在常量池中
//        String s2 = s1.intern();
//        System.out.println(s1 == s2); // true
//        String s3 = s2.intern();
//        System.out.println(s2 == s3); // true
//        System.out.println(s1 == s3); // true
//        String s4 = "hello";
//        System.out.println(s1 == s4); // true


//        String s0 = "zhuge";
//        String s1 = "zhuge";
//        String s2 = "zhu" + "ge"; // 字符串常量拼接后还是字符串常量   String s1 = new String("he") + new String("llo"); new拼接出来还是在池外堆内
//        System.out.println(s0 == s1); // true
//        System.out.println(s2 == s1); // true


        // 只要是new，就是新创建出来的对象
//        String s0 = "zhuge";
//        String s1 = new String("zhuge");
//        String s2 = "zhu" + new String("ge");
//        System.out.println(s0 == s1); // false
//        System.out.println(s0 == s2); // false
//        System.out.println(s1 == s2); // false


        // a b c都是引用，在编译器无法确定引用的地址，只有在运行时确定地址后，拼接起来赋值给s1，所以s和s1不相等
//        String s = "a" + "b" + "c"; // s是编译器就能确定引用的地址，在常量池中
//        String a = "a";
//        String b = "b";
//        String c = "c";
//        String s1 = a + b + c;
//        System.out.println(s == s1); // false


        // 注意，在字符串常量池中肯定有"java"这样的字面量，因为"java"是关键字
//        String str = new StringBuilder("计算机").append("技术").toString(); // 会new String，但是没有字面量"计算机技术"
//        System.out.println(str == str.intern()); // true
//        String str1 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str1 == str1.intern()); // false


        // "abc"是字面量
//        String s = new StringBuilder("abc").toString(); // 会new String
//        System.out.println(s == s.intern()); // false

    }
}
