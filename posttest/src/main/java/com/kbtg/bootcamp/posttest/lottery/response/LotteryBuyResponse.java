package com.kbtg.bootcamp.posttest.lottery.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LotteryBuyResponse(@JsonProperty(value = "id") Integer id) {
}
