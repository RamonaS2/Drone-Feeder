package com.dronefeeder.dronefeeder.repository;

import com.dronefeeder.dronefeeder.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*** Repositório de Entrega. ***/
@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {}