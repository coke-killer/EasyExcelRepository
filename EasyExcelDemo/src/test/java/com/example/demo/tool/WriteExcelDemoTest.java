package com.example.demo.tool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WriteExcelDemoTest {
    WriteExcelDemo writeExcelDemo = null;

    @BeforeEach
    void setUp() {
        writeExcelDemo = new WriteExcelDemo();
    }

    @Test
    void test() {
        writeExcelDemo.writeExcelOne();
    }

    @Test
    void testTwo() {
        writeExcelDemo.writeExcelTwo();
    }

    @Test
    void testThree() {
        writeExcelDemo.excludeWrite();
    }

    @Test
    void testFour() {
        writeExcelDemo.IncludeWrite();
    }

    @AfterEach
    void tearDown() {

    }
}