package com.NoHex.SuperMarketSalesControlBackend.DTOs;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ClientRequestDTO {
    private String fullName;

    private String phoneNumber;

    private String address;
}
