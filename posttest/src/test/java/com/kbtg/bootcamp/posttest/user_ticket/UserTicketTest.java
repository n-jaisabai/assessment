package com.kbtg.bootcamp.posttest.user_ticket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class UserTicketTest {
    @Test
    void whenNewUserTicket_thenResultShouldBeValid() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        UserTicket userTicket = new UserTicket();
        userTicket.setUserId(1);
        userTicket.setTicketNo("000001");
        userTicket.setPricePaid(BigDecimal.valueOf(100.50));
        userTicket.setCreatedDate(timestamp);
        userTicket.setModifiedDate(timestamp);
        userTicket.setId(5);

        assertEquals(5, userTicket.getId());
        assertEquals(1, userTicket.getUserId());
        assertEquals("000001", userTicket.getTicketNo());
        assertEquals(BigDecimal.valueOf(100.50), userTicket.getPricePaid());
        assertEquals(timestamp, userTicket.getCreatedDate());
        assertEquals(timestamp, userTicket.getModifiedDate());
    }
}
