package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {
    @ExcelProperty("二级表id")
    private String dataoffset;
    @ExcelProperty("日期标题")
    private String timestamp;
    @ExcelProperty("x线电压Ua")
    private Double ua;
    @ExcelProperty("线电压Ub")
    private Double ub;
    @ExcelProperty("线电压Uc")
    private Double uc;
    @ExcelProperty("温度")
    private String temp;
    @ExcelProperty("湿度")
    private String moisture;
    //忽略这个字段
    @ExcelIgnore
    private String ignore;
}
