package com.kbtg.bootcamp.posttest.lottery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class LotteryControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private LotteryService lotteryService;

    @BeforeEach
    void setUp() {
        LotteryController userController = new LotteryController(lotteryService);
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .alwaysDo(print())
                .build();
    }

    @Test
    void whenBuyLottery_thenShouldReturnLotteryBuyResponse() throws Exception {
        when(lotteryService.buyLottery(any(), any())).thenReturn(1);
        this.mockMvc.perform(post("/users/1/lotteries/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void whenAddLottery_thenShouldReturnLotteryAddResponse() throws Exception {
        Lottery lottery = new Lottery();
        lottery.setTicketNo("000001");
        lottery.setPrice(BigDecimal.valueOf(100));
        lottery.setAmount(10);

        when(lotteryService.addLottery(any())).thenReturn(lottery);
        this.mockMvc.perform(
                post("/admin/lotteries")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("{\"ticket\": \"000001\", \"price\": 100, \"amount\": 10}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.ticket").value("000001"));
    }

    @Test
    void whenGetLotteryList_thenShouldReturnLotteryListResponse() throws Exception {
        Lottery lottery = new Lottery();
        lottery.setTicketNo("000001");
        lottery.setPrice(BigDecimal.valueOf(100));
        lottery.setAmount(10);

        when(lotteryService.getLotteryList()).thenReturn(List.of(lottery));
        this.mockMvc.perform(get("/lotteries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tickets").isArray())
                .andExpect(jsonPath("$.tickets[0]").value("000001"));
    }

    @Test
    void whenRefundLottery_thenShouldReturnLotteryRefundResponse() throws Exception {
        when(lotteryService.refundLottery(any(), any())).thenReturn("000001");
        this.mockMvc.perform(delete("/users/1/lotteries/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ticket").value("000001"));
    }
}
