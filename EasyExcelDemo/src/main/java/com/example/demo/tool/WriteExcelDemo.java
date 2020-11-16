package com.example.demo.tool;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.demo.entity.Device;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WriteExcelDemo {
    private static List<Device> getDevice() {
        List<Device> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
        list.add(Device.builder().dataoffset("10").temp("15°").ua(10d).build());
        list.add(Device.builder().dataoffset("10").ub(20.0).build());
        list.add(Device.builder().dataoffset("10").uc(15.0).moisture("20度").build());
//        }
        return list;
    }

    //最简单的第一种写  创建Excel  对应的实体对象
    public void writeExcelOne() {
        String fineName = "src/file/" + System.currentTimeMillis() + "导出数据" + ".xlsx";
        //指定需要用到的class，写到第一个sheet，名字为"第一块810表，然后文件流自动关闭
        EasyExcel.write(fineName, Device.class).sheet("第一块810表").doWrite(getDevice());
    }

    //第二种写法
    public void writeExcelTwo() {
        String fileName = "src/file/" + System.currentTimeMillis() + "dierge导出数据" + ".xlsx";
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, Device.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("第一块810表").build();
            excelWriter.write(getDevice(), writeSheet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    //根据参数导出去掉忽略的列的剩余列
    public void excludeWrite() {
        String fileName = "src/file/" + System.currentTimeMillis() + "dierge导出数据" + ".xlsx";
        //根据用户传入字段，假设我们要忽略timestamp
        HashSet<String> excludeColumnFieldNames = new HashSet<>();
        excludeColumnFieldNames.add("timestamp");
        //指定用哪个class 写然后指定第一个sheet，名字为模板，然后文件流自然关闭
        EasyExcel.write(fileName, Device.class).excludeColumnFiledNames(excludeColumnFieldNames).sheet("810忽略timestamp的模板").doWrite(getDevice());
    }

    //导出指定列
    public void IncludeWrite() {
        String fileName = "src/file/" + System.currentTimeMillis() + "dierge导出数据" + ".xlsx";
        HashSet<String> includeColumnFileNames = new HashSet<>();
        includeColumnFileNames.add("timestamp");
        EasyExcel.write(fileName, Device.class).includeColumnFiledNames(includeColumnFileNames).sheet("810只包含 timestamp表").doWrite(getDevice());

    }
}
