package com.dronefeeder.dronefeeder.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dronefeeder.dronefeeder.model.Drone;
import com.dronefeeder.dronefeeder.repository.DroneRepository;

@Service
public class DroneService {

  @Autowired
  private DroneRepository droneRepository;

  public List<Drone> listarDrones() {
    return droneRepository.findAll();
  }

  public Drone buscarDronePorId(Long id) {
    Optional<Drone> droneOptional = droneRepository.findById(id);
    if (droneOptional.isPresent()) {
      return droneOptional.get();
    }
    throw new EntityNotFoundException("Drone não encontrado.");
  }

  public Drone criarDrone(Drone drone) {
    return droneRepository.save(drone);
  }

  public Drone atualizarDrone(Long id, Drone droneAtualizado) {
    Drone droneExistente = buscarDronePorId(id);
    droneExistente.setNome(droneAtualizado.getNome());
    droneExistente.setLatitude(droneAtualizado.getLatitude());
    droneExistente.setLongitude(droneAtualizado.getLongitude());
    return droneRepository.save(droneExistente);
  }

  public void deletarDrone(Long id) {
    Drone drone = buscarDronePorId(id);
    droneRepository.delete(drone);
  }
}
