package com.kbtg.bootcamp.posttest.lottery;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LotteryController {
    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @PostMapping("/admin/lotteries")
    public ResponseEntity<LotteryResponse> addLottery(@Valid @RequestBody LotteryRequest lottery) throws Exception {
        Lottery lotteryResult = lotteryService.addLottery(lottery);
        return ResponseEntity.status(201).body(new LotteryResponse(lotteryResult.getTicketNo()));
    }

    @GetMapping("/lotteries")
    // user can get the list of lottery tickets
    public ResponseEntity<LotteryListResponse> getLotteryList() throws Exception {
        List<Lottery> lotteryResult = lotteryService.getLotteryList();
        return ResponseEntity.status(200).body(new LotteryListResponse(
                lotteryResult.stream().map(Lottery::getTicketNo).toList()));
    }
}
