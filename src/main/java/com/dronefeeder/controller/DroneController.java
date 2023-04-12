package com.dronefeeder.controller;

import com.dronefeeder.model.Drone;
import com.dronefeeder.service.DroneService;
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

/*** Controller da rota "/drones". ***/
@RestController
@RequestMapping("/drones")
public class DroneController {

  @Autowired
  private DroneService droneService;

  @GetMapping
  public ResponseEntity<List<Drone>> listarDrones() {
    List<Drone> drones = droneService.listarDrones();
    return ResponseEntity.ok(drones);
  }
    
  @GetMapping("/{id}")
  public ResponseEntity<Drone> pegarDronePorId(@PathVariable Long id) {
    Drone drone = droneService.buscarDronePorId(id);
    return ResponseEntity.ok(drone);
  }

  @PostMapping
  public ResponseEntity<Drone> cadastrarDrone(@RequestBody Drone drone) {
    Drone droneCadastrado = droneService.criarDrone(drone);
    return ResponseEntity.status(HttpStatus.CREATED).body(droneCadastrado);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Drone> atualizarDrone(
        @PathVariable Long id,
        @RequestBody Drone droneAtualizado
  ) {
    Drone drone = droneService.atualizarDrone(id, droneAtualizado);
    return ResponseEntity.ok(drone);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarDrone(@PathVariable Long id) {
    droneService.deletarDrone(id);
    return ResponseEntity.noContent().build();
  }
}
