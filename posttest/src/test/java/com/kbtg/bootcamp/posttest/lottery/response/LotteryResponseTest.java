package com.kbtg.bootcamp.posttest.lottery.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryResponseTest {
    @Test
    void whenNewLotteryResponse_thenResultShouldBeValid() {
        LotteryResponse lotteryResponse = new LotteryResponse("000001");

        assertEquals("000001", lotteryResponse.ticket());
    }
}
