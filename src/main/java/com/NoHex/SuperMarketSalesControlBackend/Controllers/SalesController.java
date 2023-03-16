package com.NoHex.SuperMarketSalesControlBackend.Controllers;

import com.NoHex.SuperMarketSalesControlBackend.DTOs.SalesRequestDTO;
import com.NoHex.SuperMarketSalesControlBackend.DTOs.SalesResponseDTO;
import com.NoHex.SuperMarketSalesControlBackend.Entity.ClientEntity;
import com.NoHex.SuperMarketSalesControlBackend.Entity.SalesEntity;
import com.NoHex.SuperMarketSalesControlBackend.Repository.ClientRepository;
import com.NoHex.SuperMarketSalesControlBackend.Repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sales")
public class SalesController {
    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SalesEntity> getAllSales(){
        return salesRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SalesResponseDTO> createSales(@RequestBody SalesRequestDTO sales){
        ClientEntity clientEntity = clientRepository.findById(sales.getId_client()).orElseThrow();

        SalesEntity newSales = new SalesEntity();

        newSales.setClient(clientEntity);

        SalesEntity saveSales = salesRepository.save(newSales);

        SalesResponseDTO salesResponseDTO = new SalesResponseDTO();

        salesResponseDTO.setId(saveSales.getId());
        salesResponseDTO.setId_client(saveSales.getClient().getId());
        salesResponseDTO.setFecha_sale(saveSales.getFecha_sale());

        return ResponseEntity.ok(salesResponseDTO);
    }
}
