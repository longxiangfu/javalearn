package com.tc.jdk.jdk_E.stream.sorted;

import lombok.Builder;
import lombok.Data;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/4/16 17:03
 * @Version 1.0
 **/
@Data
@Builder
public class Person {
    private Integer id;
    private String name;
    private Integer age;
}
