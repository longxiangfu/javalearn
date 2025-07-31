package com.tc.hutoolTest.bean;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanTest {
    public static void main(String[] args) {
        /**
         * Map->Bean
         */
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name", "Joe");
//        map.put("age", 12);
//        map.put("openId", "DFDFSDFWERWER");
//        Person person = BeanUtil.fillBeanWithMap(map, new Person(), false);
//        System.out.println(person.toString()); // Person{name='Joe', age=12}

//        HashMap<String, Object> map = new HashMap<>();
//        map.put("Name", "Joe");
//        map.put("aGe", 12);
//        map.put("openId", "DFDFSDFWERWER");
//        Person person = BeanUtil.fillBeanWithMapIgnoreCase(map, new Person(), true);
//        System.out.println(person.toString()); // Person{name='Joe', age=12}


        /**
         * Bean->Map
         */
//        SubPerson person = new SubPerson();
//        person.setAge(14);
//        person.setName("测试A11");
//        person.setSubName("sub名字");
//        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(person);
//        System.out.println(Convert.toStr(stringObjectMap)); // {id=null, subName=sub名字, name=测试A11, age=14}


        /**
         * Bean->Bean
         */
//        SubPerson p1 = new SubPerson();
//        p1.setSlow(true);
//        p1.setName("测试");
//        p1.setSubName("sub测试");
//        SubPerson subPerson = BeanUtil.copyProperties(p1, SubPerson.class);
//        System.out.println(subPerson.toString()); // SubPerson{id=null, subName='sub测试', isSlow=null} Person{name='测试', age=0}


        /**
         * BeanUtil.getProperty--javaBean深层次嵌套时寻找
         */
//        ExamInfoDict examInfoDict = new ExamInfoDict();
//        examInfoDict.setId(1);
//        examInfoDict.setExamType(0);
//        examInfoDict.setAnswerIs(1);
//        ExamInfoDict examInfoDict1 = new ExamInfoDict();
//        examInfoDict1.setId(2);
//        examInfoDict1.setExamType(0);
//        examInfoDict1.setAnswerIs(0);
//        ExamInfoDict examInfoDict2 = new ExamInfoDict();
//        examInfoDict2.setId(3);
//        examInfoDict2.setExamType(1);
//        examInfoDict2.setAnswerIs(0);
//        List<ExamInfoDict> examInfoDicts = new ArrayList<>();
//        examInfoDicts.add(examInfoDict);
//        examInfoDicts.add(examInfoDict1);
//        examInfoDicts.add(examInfoDict2);
//
//        UserInfoDict userInfoDict = new UserInfoDict();
//        userInfoDict.setId(1);
//        userInfoDict.setPhotoPath("yx.mm.com");
//        userInfoDict.setRealName("张三");
//        userInfoDict.setExamInfoDict(examInfoDicts);
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("userInfo", userInfoDict);
//        map.put("flag", 1);
//
//        Object property = BeanUtil.getProperty(map, "userInfo.examInfoDict[1].id");
//        System.out.println(property); // 2
//        Object property1 = BeanUtil.getProperty(userInfoDict, "examInfoDict[2].id");
//        System.out.println(property1); // 3

    }


}
