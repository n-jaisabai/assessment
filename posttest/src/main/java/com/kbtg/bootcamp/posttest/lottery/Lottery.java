package com.kbtg.bootcamp.posttest.lottery;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity(name = "lottery")
public class Lottery {
    @Id
    @Column(name = "ticket_no")
    private String ticketNo;

    private BigDecimal price;

    private Integer amount;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private Timestamp modifiedDate;
}
