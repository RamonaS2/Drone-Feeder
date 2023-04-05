package com.dronefeeder.dronefeeder.controller;

import com.dronefeeder.dronefeeder.model.Entrega;
import com.dronefeeder.dronefeeder.service.EntregaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*** Controller de entregas. ***/
@RestController
@RequestMapping("/entregas")
public class EntregaController {

  @Autowired
  private EntregaService entregaService;

  @GetMapping
  public ResponseEntity<List<Entrega>> listarEntregas() {
    List<Entrega> entregas = entregaService.listarEntregas();
    return ResponseEntity.ok(entregas);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Entrega> buscarEntregaPorId(@PathVariable Long id) {
    Entrega entrega = entregaService.buscarEntregaPorId(id);
    return ResponseEntity.ok(entrega);
  }

  @PostMapping
  public ResponseEntity<Entrega> cadastrarEntrega(@RequestBody Entrega entrega) {
    Entrega entregaCadastrada = entregaService.criarEntrega(entrega);
    return ResponseEntity.status(HttpStatus.CREATED).body(entregaCadastrada);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Entrega> atualizarEntrega(
          @PathVariable Long id, @RequestBody Entrega entregaAtualizada) {
    Entrega updatedEntrega = entregaService.atualizarEntrega(id, entregaAtualizada);
    return ResponseEntity.ok(updatedEntrega);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarEntrega(@PathVariable Long id) {
    entregaService.deletarEntrega(id);
    return ResponseEntity.noContent().build();
  }
}
