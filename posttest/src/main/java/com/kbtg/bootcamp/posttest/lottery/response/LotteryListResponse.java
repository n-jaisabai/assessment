package com.kbtg.bootcamp.posttest.lottery.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record LotteryListResponse(List<String> tickets) {
}
