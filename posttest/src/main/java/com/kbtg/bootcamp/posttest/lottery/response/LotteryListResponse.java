package com.kbtg.bootcamp.posttest.lottery.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record LotteryListResponse(@JsonProperty(value = "ticket") List<String> tickets) {
}
