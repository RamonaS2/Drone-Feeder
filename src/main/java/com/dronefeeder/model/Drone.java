package com.dronefeeder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*** Entidade Drone. ***/
@Entity
public class Drone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String nome;
  private Double latitude;
  private Double longitude;
  
  @JsonIgnore
  @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL, orphanRemoval = true,
      fetch = FetchType.LAZY)
  private List<Entrega> entregas = new ArrayList<Entrega>();

  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }
  
  public List<Entrega> getEntregas() {
    return this.entregas;
  }
  
  public void setEntregas(List<Entrega> entregas) {
    this.entregas = entregas;
  }
  
  public void addEntrega(Entrega entrega) {
    this.entregas.add(entrega);
  }
}
