package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.lottery.request.LotteryRequest;
import com.kbtg.bootcamp.posttest.lottery.response.*;
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
    public ResponseEntity<LotteryResponse> addLottery(@Valid @RequestBody LotteryRequest lottery) {
        Lottery lotteryResult = lotteryService.addLottery(lottery);
        return ResponseEntity.status(201).body(new LotteryResponse(lotteryResult.getTicketNo()));
    }

    @GetMapping("/lotteries")
    public ResponseEntity<LotteryListResponse> getLotteryList() {
        List<Lottery> lotteryResult = lotteryService.getLotteryList();
        return ResponseEntity.status(200).body(new LotteryListResponse(
                lotteryResult.stream().map(Lottery::getTicketNo).toList()));
    }

    @PostMapping("/users/{userId}/lotteries/{ticketNo}")
    public ResponseEntity<LotteryBuyResponse> buyLottery(@PathVariable Integer userId, @PathVariable String ticketNo) {
        Integer purchaseId = lotteryService.buyLottery(userId, ticketNo);
        return ResponseEntity.status(200).body(new LotteryBuyResponse(purchaseId));
    }

    @GetMapping("/users/{userId}/lotteries")
    public ResponseEntity<LotteryListUserResponse> getLotteryListByUser(@PathVariable Integer userId) {
        return ResponseEntity.status(200).body(lotteryService.getLotteryListByUser(userId));
    }

    @DeleteMapping("/users/{userId}/lotteries/{ticketNo}")
    public ResponseEntity<LotteryRefundResponse> refundLottery(@PathVariable Integer userId, @PathVariable String ticketNo) {
        String refundResult = lotteryService.refundLottery(userId, ticketNo);
        return ResponseEntity.status(200).body(new LotteryRefundResponse(refundResult));
    }
}
