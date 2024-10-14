package test.cliente.service.Interface;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Prueba para obtener un usuario por ID (GET /api/usuarios/{id})
    @Test
    public void testObtenerClientePorId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/clientes/1"))
                .andExpect(status().isOk()) // Verifica que el estado sea 200 OK
                .andExpect(jsonPath("$.data.id").value(1)) // Verifica que el ID del usuario es 1
                .andExpect(jsonPath("$.data.nombre").value("Jose Lema")); // Verifica que el nombre es "Juan Pérez"
    }

    // Prueba para crear un nuevo usuario (POST /api/usuarios)
    @Test
    public void testCrearCliente() throws Exception {
        String usuarioJson = "{\"nombre\": \"Juan Osorio\", \"genero\": \"Masculino\", \"edad\": 27, \"identificacion\": \"1811556535\", \"direccion\": \"13 junio y Equinoccial\", \"telefono\": \"098874587\", \"contrasenia\": \"1245\"}";

        mockMvc.perform(post("/api/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(usuarioJson)) // Envía el JSON como cuerpo de la solicitud
                .andExpect(status().isOk()); // Verifica que el estado sea 200 OK
        // .andExpect(jsonPath("$.identificacion").value("1811556535"))
        // .andExpect(jsonPath("$.genero").value("Masculino"));
    }
}
