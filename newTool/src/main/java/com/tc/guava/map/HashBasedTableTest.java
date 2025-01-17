package com.tc.guava.map;

import cn.hutool.core.convert.Convert;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 双键Map
 * {rowKey,columnKey, value}
 */
public class HashBasedTableTest {
    public static void main(String[] args) {
        // 存储->员工  月份  工作天数
        HashBasedTable<String, String, Integer> hashBasedTable = HashBasedTable.create();
        // 1、 增   rowKey和columcKey相同时会覆盖
        hashBasedTable.put("lxf", "2", 28);
        hashBasedTable.put("lxf", "3", 31);
        hashBasedTable.put("ct", "2", 30);
        hashBasedTable.put("ct", "3", 31);
        // 2、查
        Integer lxf_2_value = hashBasedTable.get("lxf", "2");
        System.out.println("lxf_2_value" + lxf_2_value);

        // 5、获取key或value的集合
        Set<String> rowKeySet = hashBasedTable.rowKeySet();
        Set<String> columnKeySet = hashBasedTable.columnKeySet();
        Collection<Integer> values = hashBasedTable.values();
        System.out.println("rowKeySet:" + rowKeySet); // rowKeySet:[lxf, ct]
        System.out.println("columnKeySet:" + columnKeySet); // columnKeySet:[2, 3]
        System.out.println("values:" + values); // values:[28, 31, 30, 31]

        // 6、计算rowKey对应的value之和
        for (String key : hashBasedTable.rowKeySet()) {
            Set<Map.Entry<String, Integer>> rows = hashBasedTable.row(key).entrySet();
            int total = 0;
            for (Map.Entry<String, Integer> row : rows) {
                total += row.getValue();
            }
            System.out.println("total:" + total); // total:59    total:61
        }

        // 7、转换rowKey和columnKey
        Table<String, String, Integer> table2 = Tables.transpose(hashBasedTable);
        Set<Table.Cell<String, String, Integer>> cells = table2.cellSet();
        cells.forEach(cell -> System.out.println(cell.getRowKey() + "," + cell.getColumnKey() + "," + cell.getValue()));
// 结果
//        2,lxf,28
//        3,lxf,31
//        2,ct,30
//        3,ct,31

        // 8、转换为嵌套的Map
        Map<String, Map<String, Integer>> rowMap = hashBasedTable.rowMap();
        Map<String, Map<String, Integer>> columnMap = hashBasedTable.columnMap();
        System.out.println("rowMap:" + rowMap); // rowMap:{lxf={2=28, 3=31}, ct={2=30, 3=31}}
        System.out.println("columnMap:" + columnMap); // columnMap:{2={lxf=28, ct=30}, 3={lxf=31, ct=31}}

        // 4、修改
        HashBasedTable<String, String, Integer> table = HashBasedTable.create();
        table.put("lxf", "2", 28);
        table.put("lxf", "3", 31);
        table.put("ct", "2", 30);
        table.put("ct", "3", 31);
        table.put("ct", "4", 39);
        for (String rowKey : table.rowKeySet()) {
            if ("ct".equals(rowKey)) {
                // rows为[2=30, 3=31, 4=39]
                Set<Map.Entry<String, Integer>> rows = table.row(rowKey).entrySet();
                for (Map.Entry<String, Integer> row : rows) {
                    if ("2".equals(row.getKey())) {
                        row.setValue(300);
                    }
                }
            }
        }
        System.out.println(table); // {lxf={2=28, 3=31}, ct={2=300, 3=31, 4=39}}

        // 删除
//        for (Iterator<String> iterator = table.rowKeySet().iterator(); iterator.hasNext(); ) {
//            String rowKey = iterator.next();
//            if ("lxf".equals(rowKey)) {
//                iterator.remove();
//            }
//        }
//        System.out.println(Convert.toStr(table)); // {ct={2=300, 3=31, 4=39}}
//        table.rowKeySet().removeIf();
//        table.values().removeIf();
//        table.columnKeySet().removeIf();

    }
}
