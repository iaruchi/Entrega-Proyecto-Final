package com.coderhouse.Clase8.repository;

import com.coderhouse.Clase8.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
