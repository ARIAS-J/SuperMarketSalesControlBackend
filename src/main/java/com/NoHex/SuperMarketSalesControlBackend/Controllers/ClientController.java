package com.NoHex.SuperMarketSalesControlBackend.Controllers;

import com.NoHex.SuperMarketSalesControlBackend.DTOs.ClientRequestDTO;
import com.NoHex.SuperMarketSalesControlBackend.Entity.ClientEntity;
import com.NoHex.SuperMarketSalesControlBackend.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientEntity> getAllClient(){
        return clientRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ClientEntity> createClient(@RequestBody ClientRequestDTO client){
        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setFullName(client.getFullName());
        clientEntity.setPhoneNumber(client.getPhoneNumber());
        clientEntity.setAddress(client.getAddress());

        return new ResponseEntity<>(clientRepository.save(clientEntity), HttpStatus.CREATED);

    }
}
