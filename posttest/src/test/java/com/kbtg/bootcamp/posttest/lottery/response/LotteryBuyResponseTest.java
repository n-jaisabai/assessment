package com.kbtg.bootcamp.posttest.lottery.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryBuyResponseTest {
    @Test
    void whenNewLotteryBuyResponse_thenResultShouldBeValid() {
        LotteryBuyResponse lotteryBuyResponse = new LotteryBuyResponse(1);

        assertEquals(1, lotteryBuyResponse.id());
    }
}
