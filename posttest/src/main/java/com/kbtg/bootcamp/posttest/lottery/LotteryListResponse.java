package com.kbtg.bootcamp.posttest.lottery;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record LotteryListResponse(@JsonProperty(value = "ticket") List<String> tickets) {
}
