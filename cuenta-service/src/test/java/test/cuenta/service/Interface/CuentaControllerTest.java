package test.cuenta.service.Interface;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CuentaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Prueba para obtener un usuario por ID (GET /api/usuarios/{id})
    @Test
    public void testObtenerClientePorId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cuentas/1"))
                .andExpect(status().isOk());
    }

    // Prueba para crear un nuevo usuario (POST /api/usuarios)
    @Test
    public void testCrearCliente() throws Exception {
        String usuarioJson = "{\"numeroCuenta\":\"585545\",\"tipoCuenta\":\"Corriente\",\"saldoInicial\":1000,\"estado\":\"Activo\",\"clienteid\":1}";

        mockMvc.perform(post("/api/cuentas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(usuarioJson)) // Envía el JSON como cuerpo de la solicitud
                .andExpect(status().isOk());
    }
}
