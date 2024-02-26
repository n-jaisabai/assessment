package com.kbtg.bootcamp.posttest.lottery;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryTest {
    @Test
    void whenNewLottery_thenResultShouldBeValid() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Lottery lottery = new Lottery();
        lottery.setTicketNo("123456");
        lottery.setPrice(BigDecimal.valueOf(100));
        lottery.setAmount(20);
        lottery.setCreatedDate(timestamp);
        lottery.setModifiedDate(timestamp);

        assertEquals("123456", lottery.getTicketNo());
        assertEquals(BigDecimal.valueOf(100), lottery.getPrice());
        assertEquals(20, lottery.getAmount());
        assertEquals(timestamp, lottery.getCreatedDate());
        assertEquals(timestamp, lottery.getModifiedDate());
    }
}
