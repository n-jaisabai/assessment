package com.kbtg.bootcamp.posttest.lottery.response;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryListResponseTest {
    @Test
    void whenNewLotteryListResponse_thenResultShouldBeValid() {
        LotteryListResponse lotteryListResponse = new LotteryListResponse(List.of("1", "3", "5"));

        assertEquals("1", lotteryListResponse.tickets().get(0));
        assertEquals("3", lotteryListResponse.tickets().get(1));
        assertEquals("5", lotteryListResponse.tickets().get(2));
    }
}
