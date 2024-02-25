package com.kbtg.bootcamp.posttest.lottery;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryService {
    private final LotteryRepository lotteryRepository;

    public LotteryService(LotteryRepository lotteryRepository) {
        this.lotteryRepository = lotteryRepository;
    }

    public List<Lottery> getLotteryList() {
        return lotteryRepository.findAll();
    }

    public Lottery addLottery(LotteryRequest lotteryRequest) throws Exception {
        Lottery lottery = new Lottery();
        lottery.setTicketNo(lotteryRequest.getTicketNo());
        lottery.setPrice(lotteryRequest.getPrice());
        lottery.setAmount(lotteryRequest.getAmount());

        lotteryRepository.findById(lottery.getTicketNo()).ifPresent((l) -> {
            throw new IllegalArgumentException("Lottery ticket is already exist");
        });

        return lotteryRepository.save(lottery);
    }
}
