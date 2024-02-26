package com.kbtg.bootcamp.posttest.lottery.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryRefundResponseTest {
    @Test
    void whenNewLotteryRefundResponse_thenResultShouldBeValid() {
        LotteryRefundResponse lotteryRefundResponse = new LotteryRefundResponse("1");

        assertEquals("1", lotteryRefundResponse.ticket());
    }
}
