package com.kbtg.bootcamp.posttest.lottery;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "lottery")
public class Lottery {
    @Id
    @Column(name = "ticket_no")
    private String ticketNo;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "amount")
    private Integer amount;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private Timestamp modifiedDate;
}
