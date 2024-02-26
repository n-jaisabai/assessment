package com.kbtg.bootcamp.posttest.lottery;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BuyLotteryResponse(@JsonProperty(value = "id") Integer id) {
}
