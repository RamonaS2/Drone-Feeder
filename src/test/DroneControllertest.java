import com.dronefeeder.dronefeeder.model.Drone;
import com.dronefeeder.dronefeeder.service.DroneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DroneControllerTest {

    @Mock
    private DroneService droneService;

    private DroneController droneController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        droneController = new DroneController(droneService);
    }

    @Test
    public void listarDronesRetornaListaDeDrones() {
        // Cenário
        List<Drone> drones = new ArrayList<>();
        Drone drone1 = new Drone();
        Drone drone2 = new Drone();
        drones.add(drone1);
        drones.add(drone2);

        when(droneService.listarDrones()).thenReturn(drones);

        // Ação
        ResponseEntity<List<Drone>> responseEntity = droneController.listarDrones();

        // Verificação
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(drones, responseEntity.getBody());
    }

    @Test
    public void pegarDronePorIdRetornaDroneExistente() {
        // Cenário
        Long id = 1L;
        Drone drone = new Drone();

        when(droneService.buscarDronePorId(id)).thenReturn(drone);

        // Ação
        ResponseEntity<Drone> responseEntity = droneController.pegarDronePorId(id);

        // Verificação
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(drone, responseEntity.getBody());
    }

    @Test
    public void cadastrarDroneRetornaDroneCriado() {
        // Cenário
        Drone drone = new Drone();
        Drone droneCadastrado = new Drone();

        when(droneService.criarDrone(drone)).thenReturn(droneCadastrado);

        // Ação
        ResponseEntity<Drone> responseEntity = droneController.cadastrarDrone(drone);

        // Verificação
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(droneCadastrado, responseEntity.getBody());
    }

    @Test
    public void atualizarDroneRetornaDroneAtualizado() {
        // Cenário
        Long id = 1L;
        Drone droneAtualizado = new Drone();
        Drone droneAtualizadoRetornado = new Drone();

        when(droneService.atualizarDrone(id, droneAtualizado)).thenReturn(droneAtualizadoRetornado);

        // Ação
        ResponseEntity<Drone> responseEntity = droneController.atualizarDrone(id, droneAtualizado);

        // Verificação
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(droneAtualizadoRetornado, responseEntity.getBody());
    }

    @Test
    public void deletarDroneRetornaSemConteudo() {
        // Cenário
        Long id = 1L;

        // Ação
        ResponseEntity<Void> responseEntity = droneController.deletarDrone(id);

        // Verificação
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(droneService, times(1)).deletarDrone(id);
    }

}
