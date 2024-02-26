package com.kbtg.bootcamp.posttest.lottery.response;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryListUserResponseTest {
    @Test
    void whenNewLotteryListUserResponse_thenResultShouldBeValid() {
        LotteryListUserResponse lotteryListUserResponse = new LotteryListUserResponse(List.of("1", "3", "5"), 3, BigDecimal.valueOf(300.63));

        assertEquals(List.of("1", "3", "5"), lotteryListUserResponse.tickets());
        assertEquals(3, lotteryListUserResponse.count());
        assertEquals(BigDecimal.valueOf(300.63), lotteryListUserResponse.cost());
    }
}
