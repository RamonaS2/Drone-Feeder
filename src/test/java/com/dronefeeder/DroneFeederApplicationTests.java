package com.dronefeeder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dronefeeder.model.Drone;
import com.dronefeeder.repository.DroneRepository;
import com.dronefeeder.repository.EntregaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/*** Testes da aplicação. ***/
@SpringBootTest
@AutoConfigureMockMvc
public class DroneFeederApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private DroneRepository droneRepository;
  
  @SpyBean
  private EntregaRepository entregaRepository;

  @BeforeEach
  public void setup() {
    droneRepository.deleteAll();
    entregaRepository.deleteAll();
  }

  @Test
  @DisplayName("Testa listar todos os Drones.")
  public void testListarDrones() throws Exception {
    final var drone1 = new Drone();
    
    drone1.setId(1L);
    drone1.setLatitude(1.45D);
    drone1.setLongitude(1.45D);
    drone1.setNome("Drone 1");
    
    final var drone2 = new Drone();
    
    drone2.setId(2L);
    drone2.setLatitude(2.45D);
    drone2.setLongitude(3.45D);
    drone2.setNome("Drone 2");

    droneRepository.save(drone1);
    droneRepository.save(drone2);
    
    final var result =
        mockMvc.perform(get("/drones").contentType(MediaType.APPLICATION_JSON)); 

    result
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].nome").value(drone1.getNome()))
        .andExpect(jsonPath("$[0].latitude").value(drone1.getLatitude()))
        .andExpect(jsonPath("$[0].longitude").value(drone1.getLongitude()))
        .andExpect(jsonPath("$[1].nome").value(drone2.getNome()))
        .andExpect(jsonPath("$[1].latitude").value(drone2.getLatitude()))
        .andExpect(jsonPath("$[1].longitude").value(drone2.getLongitude()));
  }
}
