package com.kbtg.bootcamp.posttest.lottery;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, String>{

    @Transactional
    @Modifying
    @Query("UPDATE Lottery l SET l.amount=:amount WHERE l.ticketNo=:id")
    void updateAmount(@Param("id") String ticketNo, @Param("amount") Integer amount);
}
