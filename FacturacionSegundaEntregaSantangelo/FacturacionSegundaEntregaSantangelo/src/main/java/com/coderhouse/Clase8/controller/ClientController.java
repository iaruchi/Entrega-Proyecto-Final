package com.coderhouse.Clase8.controller;

import com.coderhouse.Clase8.middleware.ResponseHandler;
import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {
@Autowired
private ClientService clientService;

// Para poder utilizar el POST en client
    @PostMapping
    public ResponseEntity<Object> postClient(@RequestBody Cliente client) {
        try {
            System.out.println(client);
            Cliente clientSaved = clientService.postClient(client);
            return ResponseHandler.generateResponse(
                    "Client stored successfully",
                    HttpStatus.OK,
                    clientSaved
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null );
        }
        }
    // Para poder utilizar el GET en client
    @GetMapping(path = "{id}")
        public ResponseEntity<Object> getClient(@PathVariable() int id) {
        try {
            Cliente getClient = clientService.getClient(id);
            return ResponseHandler.generateResponse(
                    "Client extracted successfully",
                    HttpStatus.OK,
                    getClient

            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null );
        }
    }
    // Para poder utilizar el DELETE en client
    @DeleteMapping(path = "{id}")
        public void DeleteClient(@PathVariable int id) throws Exception {
            clientService.DeleteClient(id);
    }
    // Para poder utilizar el PUT en client
    @PutMapping(path = "{id}")
    public ResponseEntity<Object> UpdateClient(@PathVariable int id,@RequestBody Cliente client) throws Exception {
        try {
            Cliente clientUpdated = clientService.updateClient(id,client);
            return ResponseHandler.generateResponse(
                    "Client extracted successfully",
                    HttpStatus.OK,
                    clientUpdated
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null );
        }
    }
}


