package com.dronefeeder.service;

import com.dronefeeder.model.Entrega;
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

  public Entrega criarEntrega(Entrega entrega) {
    return entregaRepository.save(entrega);
  }

  /*** Atualiza dados de uma entrega. ***/
  public Entrega atualizarEntrega(
        Long entregaId, Entrega entregaDetails) throws EntityNotFoundException {
    Entrega entrega = buscarEntregaPorId(entregaId);

    entrega.setDataHora(entregaDetails.getDataHora());
    entrega.setVideo(entregaDetails.getVideo());
    entrega.setDrone(entregaDetails.getDrone());
    entrega.setStatus(entregaDetails.getStatus());

    return entregaRepository.save(entrega);
  }

  /*** Delete uma entrega. ***/
  public void deletarEntrega(Long entregaId) throws EntityNotFoundException {
    Entrega entrega = buscarEntregaPorId(entregaId);
    entregaRepository.delete(entrega);
  }
}
