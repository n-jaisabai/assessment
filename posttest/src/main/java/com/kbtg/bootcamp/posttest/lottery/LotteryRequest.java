package com.kbtg.bootcamp.posttest.lottery;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LotteryRequest {
    @Id
    @JsonProperty("ticket")
    @NotNull(message = "ticket is required")
    @Size(min = 6, max = 6, message = "ticket must be 6 characters")
    @Pattern(regexp = "^[0-9]*$", message = "ticket must be numeric")
    private String ticketNo;

    @NotNull(message = "price is required")
    private BigDecimal price;

    @NotNull(message = "amount is required")
    private Integer amount;
}
