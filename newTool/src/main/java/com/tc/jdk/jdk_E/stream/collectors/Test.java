package com.tc.jdk.jdk_E.stream.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 23, "New York"),
                new User("Bob", 31, "New York"),
                new User("Charlie", 23, "London"),
                new User("David", 31, "London"),
                new User("Eve", 28, "New York")
        );
        
        /*
         1. 转换为集合类    这些方法用于将 Stream 收集为 List、Set 或特定的 Collection
         */
        // toList()   将流元素收集到一个 List 中
        List<String> names = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        // 结果: ["Alice", "Bob", "Charlie", "David", "Eve"]

        // toSet()  将流元素收集到一个 Set 中，自动去重
        Set<Integer> ages = users.stream()
                .map(User::getAge)
                .collect(Collectors.toSet());
        // 结果: [23, 31, 28] (顺序可能不同)

        // toCollection(Supplier)  将流元素收集到指定的集合类型中（如 LinkedList）
        users.stream()
                .map(User::getName)
                .collect(Collectors.toCollection(LinkedList::new));
        // 结果: LinkedList 包含所有名字

        /*
         2. 转换为 Map   这些方法用于将流元素转换为 Map
         */
        // toMap(Function, Function)   将流转换为 Map，指定 Key 和 Value。如果 Key 重复会抛出异常
        Map<String, Integer> nameToAge = users.stream()
                .collect(Collectors.toMap(User::getName, User::getAge));
        // 结果: {Alice=23, Bob=31, Charlie=23, David=31, Eve=28}

        // toMap(Function, Function, BinaryOperator) 处理 Key 冲突的版本。当 Key 重复时，使用提供的函数选择保留的值。
        // 假设我们要按年龄做Key，如果有重复年龄，保留名字字典序靠后的
        Map<Integer, String> ageToName = users.stream()
                .collect(Collectors.toMap(
                        User::getAge,
                        User::getName,
                        (existing, replacement) -> existing.length() > replacement.length() ? existing : replacement
                ));

        /*
         3. 字符串拼接
         */
        // joining() 将所有元素拼接成一个字符串
        users.stream()
                .map(User::getName)
                .collect(Collectors.joining());
        // 结果: "AliceBobCharlieDavidEve"

        // joining(CharSequence delimiter)  使用分隔符拼接
        String namesWithComma = users.stream()
                .map(User::getName)
                .collect(Collectors.joining(", "));
        // 结果: "Alice, Bob, Charlie, David, Eve"

        // joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)  带前缀和后缀的拼接
        String namesFormatted = users.stream()
                .map(User::getName)
                .collect(Collectors.joining(" | ", "[ ", " ]"));
        // 结果: "[ Alice | Bob | Charlie | David | Eve ]"

        /*
         4. 统计与归约  这些方法用于计算数值流的总和、平均值、数量等
         */
        // counting()  计算流中元素的数量
        Integer totalAge = users.stream()
                .collect(Collectors.summingInt(User::getAge));
        // 结果: 23 + 31 + 23 + 31 + 28 = 136

        // averagingInt(ToIntFunction) / averagingDouble  计算属性的平均值
        Double avgAge = users.stream()
                .collect(Collectors.averagingInt(User::getAge));
        // 结果: 27.2

        // summarizingInt(ToIntFunction)  获取一个包含数量、总和、最小值、平均值、最大值的汇总对象
        IntSummaryStatistics intSummaryStatistics = users.stream()
                .collect(Collectors.summarizingInt(User::getAge));
        System.out.printf("intSummaryStatistics:" + intSummaryStatistics);
        // 结果：intSummaryStatistics:IntSummaryStatistics{count=5, sum=136, min=23, average=27.200000, max=31}

        // maxBy(Comparator) / minBy(Comparator)  根据比较器找到最大或最小的元素
        users.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(User::getAge)))
                .ifPresent(System.out::println);
        // 结果: Bob (31, New York) 或 David (31, London)

        // reducing(BinaryOperator) / reducing(init, BinaryOperator)  通用的归约操作
        // // 计算所有名字的总长度
        users.stream()
                .collect(Collectors.reducing(0, user -> user.getName().length(), Integer::sum));

        /*
         5. 分组  这是 Collectors 中最强大的功能之一
         */
        // groupingBy(Function)  根据函数返回的值进行分组，Value 默认为 List
        Map<String, List<User>> byCity = users.stream()
                .collect(Collectors.groupingBy(User::getCity));
        // 结果: {
        //   New York=[Alice, Bob, Eve],
        //   London=[Charlie, David]
        // }

        // groupingBy(Function, Collector)  分组后，对 Value 进行进一步的收集（下游收集器）
        // 对应到 User 场景：按城市分组，并计算每个城市的人数
        Map<String, Long> cityCount = users.stream()
                .collect(Collectors.groupingBy(User::getCity, Collectors.counting()));
        // 结果: {New York=3, London=2}

        // groupingBy(Function, Supplier, Collector)  指定生成的 Map 的具体类型（如 TreeMap）
        users.stream()
                .collect(Collectors.groupingBy(
                        User::getCity, 
                        TreeMap::new, 
                        Collectors.toList()
                ));
        // 结果: 是一个 TreeMap，Key 是排序的

        /*
         6. 分区  分区是分组的一种特殊情况，Key 只能是 Boolean
         */
        // partitioningBy(Predicate)  根据条件将流分为 true 和 false 两组
        Map<Boolean, List<User>> partitioned
                = users.stream()
                .collect(Collectors.partitioningBy(user -> user.getAge() > 3));
        System.out.println("partitioned:" + partitioned);
        // 结果： partitioned:{false=[], true=[Alice (23, New York), Bob (31, New York), Charlie (23, London), David (31, London), Eve (28, New York)]}

        // partitioningBy(Predicate, Collector)  分区后对 Value 进行下游收集
        Map<Boolean, Long> partitionCount = users.stream()
                .collect(Collectors.partitioningBy(u -> u.getAge() > 25, Collectors.counting()));
        System.out.println("partitionCount:" + partitionCount);
        // 结果：partitionCount:{false=2, true=3}
        
        /*
         7. 组合与其他高级操作
         */
        // mapping(Function, Collector)  在累积之前对元素应用转换函数。常用于 groupingBy 或 toMap 的下游
        // 按城市分组，但只保留每组中用户的名字，而不是整个 User 对象
        Map<String, List<String>> collect = users.stream()
                .collect(Collectors.groupingBy(
                        User::getCity,
                        Collectors.mapping(User::getName, Collectors.toList())
                ));
        System.out.println("collect:" + collect);
        // 结果: {New York=[Alice, Bob, Eve], London=[Charlie, David]}
        
        // collectingAndThen(Collector, Function)  在收集完成后，对结果应用最终的转换函数
        // // 将收集到的 List 转换为不可变 List
        List<String> collect1 = users.stream()
                .map(User::getName)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
        System.out.println("collect1:" + collect1);
        // 结果：collect1:[Alice, Bob, Charlie, David, Eve]
        
        // filtering(Predicate, Collector) (Java 9+)
        // 在收集之前过滤元素（与 Stream.filter 不同，这会影响空组的处理）
        Map<String, List<User>> collect2 = users.stream()
                .collect(Collectors.groupingBy(
                        User::getCity,
                        Collectors.filtering(u -> u.getAge() > 25, Collectors.toList())
                ));
        System.out.println("collect2:" + collect2);
        // 结果：collect2:{New York=[Bob (31, New York), Eve (28, New York)], London=[David (31, London)]}

        // 假设 User 有一个 List<String> getTags() 方法
        // 按城市分组，并将该城市所有用户的标签合并到一个 List 中
        // Map<String, List<String>> tagsByCity = users.stream()
        //     .collect(Collectors.groupingBy(
        //         User::getCity, 
        //         Collectors.flatMapping(u -> u.getTags().stream(), Collectors.toList())
        //     ));


    }
}
