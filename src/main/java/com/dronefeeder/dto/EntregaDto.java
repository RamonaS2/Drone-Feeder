package com.dronefeeder.dto;

import java.time.LocalDateTime;

/*** Dto para Entrega. ***/
public class EntregaDto {

  private LocalDateTime dataHora;
  private String video;
  private String status;
  private Long droneId;

  public LocalDateTime getDataHora() {
    return dataHora;
  }

  public void setDataHora(LocalDateTime dataHora) {
    this.dataHora = dataHora;
  }

  public String getVideo() {
    return video;
  }

  public void setVideo(String video) {
    this.video = video;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getDroneId() {
    return droneId;
  }

  public void setDroneId(Long droneId) {
    this.droneId = droneId;
  }
}
