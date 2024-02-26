package com.kbtg.bootcamp.posttest.lottery.request;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryRequestTest {
    @Test
    void whenNewLotteryRequestWithCorrectData_thenResultShouldBeValid() {
        LotteryRequest lotteryRequest = new LotteryRequest();
        lotteryRequest.setTicketNo("123456");
        lotteryRequest.setPrice(BigDecimal.valueOf(100));
        lotteryRequest.setAmount(20);

        assertEquals("123456", lotteryRequest.getTicketNo());
        assertEquals(BigDecimal.valueOf(100), lotteryRequest.getPrice());
        assertEquals(20, lotteryRequest.getAmount());
    }
}
