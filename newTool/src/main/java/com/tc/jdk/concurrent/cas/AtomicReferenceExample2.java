package com.tc.jdk.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Description CAS
 * @Author Administrator
 * @DATE 2019/4/15 14:32
 * @Version 1.0
 **/
public class AtomicReferenceExample2 {
    public static void main(String[] args) {
        //AtomicBollean AtomicInteger AtomicLong AtomicReference

        //1、cas操作，系统cpu保证操作的原子性，原子操作对应系统的一条指令
//        AtomicInteger count = new AtomicInteger(0);
//        count.incrementAndGet();
//        System.out.println(count.get()); // 1
//        boolean result = count.compareAndSet(1, 100);
//        System.out.println(result); // true
//        System.out.println(count.get()); // 100

//        Person initP = new Person();
//        initP.setId(1);
//        initP.setName("longxiangfu1");
//        AtomicReference<Person> reference = new AtomicReference<>(initP);
//        Person newP = new Person();
//        newP.setId(2);
//        newP.setName("longxiangfu2");
////        reference.compareAndSet(initP, newP); // id|name:2|longxiangfu2
//        reference.compareAndSet(newP, newP); // id|name:1|longxiangfu1
//        System.out.println("id|name:" + reference.get().getId() + "|" + reference.get().getName());



        // 2、cas造成ABA问题：一个线程把值+1，然后再-1，对另一个线程而言，值不变，这可能带来问题
        // 解决：使用AtomicStampedReference进行版本控制
//        AtomicStampedReference atomicStampedReference = new AtomicStampedReference<>(100, 1);
//        System.out.println("reference:" + atomicStampedReference.getReference());//reference:100
//        System.out.println("stamp:" + atomicStampedReference.getStamp());//stamp:1
//        atomicStampedReference.compareAndSet(atomicStampedReference.getReference(), 200,
//                atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
//        System.out.println("reference:" + atomicStampedReference.getReference());//reference:200
//        System.out.println("stamp:" + atomicStampedReference.getStamp());//stamp:2

        // AtomicMarkableReference是AtomicStampedReference简化版，只关心是否修改过
        AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(100, false);
        int ref = (int)atomicMarkableReference.getReference();
        boolean mark = atomicMarkableReference.isMarked();
        atomicMarkableReference.compareAndSet(ref, 200, mark, true);
        System.out.println("reference:" + atomicMarkableReference.getReference()); // reference:200
        System.out.println("mark:" + atomicMarkableReference.isMarked()); // mark:true


    }
}
