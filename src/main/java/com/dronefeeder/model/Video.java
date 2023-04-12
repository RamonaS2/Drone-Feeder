package com.dronefeeder.model;

/*** Classe que representa um vídeo. ***/
public class Video {
  private String nome;

  public Video(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}