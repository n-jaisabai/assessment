package com.kbtg.bootcamp.posttest.lottery;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<LotteryListResponse> getLotteryList() throws Exception {
        List<Lottery> lotteryResult = lotteryService.getLotteryList();
        return ResponseEntity.status(200).body(new LotteryListResponse(
                lotteryResult.stream().map(Lottery::getTicketNo).toList()));
    }

    @PostMapping("/user/{userId}/lotteries/{ticketNo}")
    public ResponseEntity<LotteryBuyResponse> buyLottery(@PathVariable Integer userId, @PathVariable String ticketNo) throws Exception {
        Integer purchaseId = lotteryService.buyLottery(userId, ticketNo);
        return ResponseEntity.status(200).body(new LotteryBuyResponse(purchaseId));
    }

    @GetMapping("/user/{userId}/lotteries")
    public ResponseEntity<LotteryListUserResponse> getLotteryListByUser(@PathVariable Integer userId) throws Exception {
        return ResponseEntity.status(200).body(lotteryService.getLotteryListByUser(userId));
    }
}
