package com.tc.hutoolTest.utilTest;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    private int a;

    public TestClass(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
        System.out.println(a);
    }

    public List<String> getList(){
        return new ArrayList<>();
    }

    public Integer intTest(Integer integer) {
        return 1;
    }


}
