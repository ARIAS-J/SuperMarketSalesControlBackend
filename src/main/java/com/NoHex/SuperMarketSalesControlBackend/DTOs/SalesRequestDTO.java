package com.NoHex.SuperMarketSalesControlBackend.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SalesRequestDTO {
    private LocalDateTime fecha_sale;
    private long id_client;
}
