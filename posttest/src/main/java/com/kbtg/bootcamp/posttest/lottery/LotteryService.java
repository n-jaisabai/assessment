package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.exception.NotFoundException;
import com.kbtg.bootcamp.posttest.user_ticket.UserTicket;
import com.kbtg.bootcamp.posttest.user_ticket.UserTicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LotteryService {
    private final LotteryRepository lotteryRepository;
    private final UserTicketRepository userTicketRepository;

    public LotteryService(LotteryRepository lotteryRepository, UserTicketRepository userTicketRepository) {
        this.lotteryRepository = lotteryRepository;
        this.userTicketRepository = userTicketRepository;
    }

    public List<Lottery> getLotteryList() {
        return lotteryRepository.findAll();
    }

    public Lottery addLottery(LotteryRequest lotteryRequest) {
        Lottery lottery = new Lottery();
        lottery.setTicketNo(lotteryRequest.getTicketNo());
        lottery.setPrice(lotteryRequest.getPrice());
        lottery.setAmount(lotteryRequest.getAmount());

        lotteryRepository.findById(lottery.getTicketNo()).ifPresent((l) -> {
            throw new IllegalArgumentException("Lottery ticket is already exist");
        });

        return lotteryRepository.save(lottery);
    }

    @Transactional
    public Integer buyLottery(Integer userId, String ticketNo) {
        Lottery lottery = lotteryRepository.findById(ticketNo).orElseThrow(() -> new NotFoundException("ticket not found"));

        if (lottery.getAmount() <= 0) {
            throw new IllegalArgumentException("ticket is sold out");
        }

        UserTicket userTicket = new UserTicket();
        userTicket.setUserId(userId);
        userTicket.setTicketNo(ticketNo);
        userTicket.setPricePaid(lottery.getPrice());
        userTicketRepository.save(userTicket);

        lotteryRepository.updateAmount(ticketNo, lottery.getAmount() - 1);

        return userTicket.getId();
    }

    public LotteryListUserResponse getLotteryListByUser(Integer userId) throws Exception {
        List<UserTicket> result = userTicketRepository.findByUserId(userId).orElse(List.of());
        return new LotteryListUserResponse(
                result.stream().map(UserTicket::getTicketNo).toList(),
                result.size(),
                result.stream().map(UserTicket::getPricePaid).reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    @Transactional
    public String refundLottery(Integer userId, String ticketNo) throws Exception {
        Lottery lottery = lotteryRepository.findById(ticketNo).orElseThrow(() -> new NotFoundException("ticket not found"));

        UserTicket userTicket = userTicketRepository.findByUserIdAndTicketNo(userId, ticketNo).orElseThrow(() -> new NotFoundException("transaction not found"));

        userTicketRepository.delete(userTicket);
        lotteryRepository.updateAmount(ticketNo, lottery.getAmount() + 1);

        return userTicket.getTicketNo();
    }
}
