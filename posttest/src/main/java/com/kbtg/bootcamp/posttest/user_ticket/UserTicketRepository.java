package com.kbtg.bootcamp.posttest.user_ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTicket, Integer> {

    @Query("SELECT ut FROM UserTicket ut WHERE ut.userId = :userId")
    Optional<List<UserTicket>> findByUserId(@Param("userId") Integer userId);

    @Query("SELECT ut FROM UserTicket ut WHERE ut.userId = :userId AND ut.ticketNo = :ticketNo")
    Optional<UserTicket> findByUserIdAndTicketNo(Integer userId, String ticketNo);
}
