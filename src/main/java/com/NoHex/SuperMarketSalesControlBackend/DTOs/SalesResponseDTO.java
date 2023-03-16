package com.NoHex.SuperMarketSalesControlBackend.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SalesResponseDTO {
    private long id;
    private long id_client;
    private LocalDateTime fecha_sale;
}
