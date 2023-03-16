package com.NoHex.SuperMarketSalesControlBackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name="client")
@Getter
@Setter
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String fullName;

    @Column(length = 16)
    private String phoneNumber;

    @Column(length = 255)
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<SalesEntity> sales;

}