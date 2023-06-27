package com.coderhouse.Clase8.service;

import ch.qos.logback.core.net.server.Client;
import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.repository.ClienteRepository;
import org.apache.catalina.Cluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
    public class ClientService {
        @Autowired
        private ClienteRepository clienteRepository;

        public Cliente postClient(Cliente client) throws Exception {
            return clienteRepository.save(client);
        }

        public Cliente getClient(int id) throws Exception {
            Optional<Cliente> cliente = clienteRepository.findById(id);
            if (cliente.isEmpty()){
                throw new Exception("Client with id:" + id + ", not found");

            } else {
                return cliente.get();
            }

        }
        public boolean clientExist (int id) throws Exception {
            Optional<Cliente> cliente = clienteRepository.findById(id);
            return cliente.isPresent();
        }
        public void DeleteClient(int id){
             clienteRepository.deleteById(id);
        }

        public Cliente updateClient (int id, Cliente client){
            Cliente c = clienteRepository.findById(id).get();
            c.setLastname(client.getLastname());
            c.setName(client.getName());
            c.setDocnumber(client.getDocnumber());
            return clienteRepository.save(c);
        }
    }
