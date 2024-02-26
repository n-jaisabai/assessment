package com.kbtg.bootcamp.posttest.user_ticket;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user_ticket")
public class UserTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ticket_no")
    private String ticketNo;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "price_paid")
    private BigDecimal pricePaid;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private Timestamp modifiedDate;
}
