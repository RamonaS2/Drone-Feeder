package com.dronefeeder.service;

import com.dronefeeder.dto.EntregaDto;
import com.dronefeeder.model.Drone;
import com.dronefeeder.model.Entrega;
import com.dronefeeder.repository.DroneRepository;
import com.dronefeeder.repository.EntregaRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*** Service de Entrega. ***/
@Service
public class EntregaService {

  @Autowired
  private EntregaRepository entregaRepository;
  
  @Autowired
  private DroneRepository droneRepository;

  public List<Entrega> listarEntregas() {
    return entregaRepository.findAll();
  }

  /*** Busca entrega por Id. ***/
  public Entrega buscarEntregaPorId(Long entregaId) throws EntityNotFoundException {
    Optional<Entrega> entregaOptional = entregaRepository.findById(entregaId);

    if (entregaOptional.isPresent()) {
      return entregaOptional.get();
    }

    throw new EntityNotFoundException("Entrega não encontrada.");
  }

  /*** Cria uma nova entrega. ***/
  public Entrega criarEntrega(EntregaDto novaEntrega) {
    Entrega entrega = new Entrega();
    entrega.setDataHora(novaEntrega.getDataHora());
    entrega.setVideo(novaEntrega.getVideo());
    entrega.setStatus(novaEntrega.getStatus());

    Optional<Drone> droneOptional = droneRepository.findById(novaEntrega.getDroneId());
    if (!droneOptional.isPresent()) {
      throw new IllegalArgumentException(
          "Drone não encontrado com o ID " + novaEntrega.getDroneId());
    }

    Drone drone = droneOptional.get();
    entrega.setDrone(drone);

    drone.addEntrega(entrega);
    droneRepository.save(drone);

    return entregaRepository.save(entrega);
  }

  /*** Atualiza dados de uma entrega. ***/
  public Entrega atualizarEntrega(
        Long entregaId, EntregaDto entregaDetails) throws EntityNotFoundException {
    Entrega entrega = buscarEntregaPorId(entregaId);
    
    Optional<Drone> droneOptional = droneRepository.findById(entregaDetails.getDroneId());
    if (!droneOptional.isPresent()) {
      throw new IllegalArgumentException(
          "Drone não encontrado com o ID " + entregaDetails.getDroneId());
    }

    Drone drone = droneOptional.get();
    entrega.setDrone(drone);

    entrega.setDataHora(entregaDetails.getDataHora());
    entrega.setVideo(entregaDetails.getVideo());
    entrega.setStatus(entregaDetails.getStatus());

    return entregaRepository.save(entrega);
  }

  /*** Delete uma entrega. ***/
  public void deletarEntrega(Long entregaId) throws EntityNotFoundException {
    Entrega entrega = buscarEntregaPorId(entregaId);
    entregaRepository.delete(entrega);
  }
}
