package com.RefactoryAndCleanCode;

import org.junit.Before;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class StringCarculatorTest {
    private StringCarculator cal;

    @Before
    public void Setup() { //테스트 마다 초기화
        cal = new StringCarculator();
        System.out.println(cal);
    }


    @Test
    void add_null_or_emptyText() {
        cal = new StringCarculator();
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }

    @Test
    void add_singleNumber() throws Exception {
        cal = new StringCarculator();
        assertEquals(1, cal.add("1"));
    }

    @Test
    void add_sum() throws Exception {
        cal = new StringCarculator();
        assertEquals(4, cal.add("2,2:3"));
    }
}