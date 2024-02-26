package com.kbtg.bootcamp.posttest.lottery.response;

import java.math.BigDecimal;
import java.util.List;

public record LotteryListUserResponse(List<String> tickets, Integer count, BigDecimal cost) {
}
