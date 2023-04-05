package com.dronefeeder.dronefeeder.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*** Entidade Entrega. ***/
@Entity
public class Entrega {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "data_hora")
  private LocalDateTime dataHora;

  @Column
  private String tipo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "drone_id", referencedColumnName = "id")
  private Drone drone;

  
}
