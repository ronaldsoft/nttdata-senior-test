package test.cliente.service.Interface;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.cliente.service.Application.service.ClienteService;
import test.cliente.service.Domain.model.Cliente;
import test.cliente.service.Domain.model.Response;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    // inyeccion de servicios
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Response<Cliente> crearCliente(@RequestBody Cliente cliente) {
        try {
            Cliente clienteGuardado = clienteService.crearCliente(cliente);
            return new Response<>(1, "Datos guardados", Optional.of(clienteGuardado));
        } catch (Exception e) {
            return new Response<>(0, "No se pudo crear cliente", null); // Devolvemos un error si no se pudo guardar
        }
    }

    @GetMapping("/{id}")
    public Response<Cliente> obtenerClientePorId(@PathVariable Long id) {
        try {
            Cliente clientePorId = clienteService.obtenerClientePorId(id);
            return new Response<>(1, "Consulta exitosa", Optional.of(clientePorId));
        } catch (Exception e) {
            return new Response<>(0, "No se pudo obtener datos", null); // Devolvemos un error si no se pudo guardar
        }
    }

    // Obtener todos los clientes (GET)
    @GetMapping
    public Response<List<Cliente>> obtenerTodosLosClientes() {
        try {
            List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
            if (clientes.isEmpty()) {
                return new Response<>(0, "No se encontraron datos", null); // No hay datos
            } else {
                return new Response<>(1, "Datos encontrados", Optional.of(clientes)); // Datos encontrados
            }
        } catch (Exception e) {
            return new Response<>(0, "No se pudo obtener datos", null); // Devolvemos un error si no se pudo guardar
        }
    }

    // Actualizar un cliente (PUT)
    @PutMapping("/{id}")
    public Response<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteDetalles) {
        try {
            Cliente clienteGuardado = clienteService.actualizarCliente(id, clienteDetalles);
            return new Response<>(1, "Datos actualizados", Optional.of(clienteGuardado));
        } catch (Exception e) {
            return new Response<>(0, "No se actualizar datos", null); // Devolvemos un error si no se pudo guardar
        }
    }

    // Eliminar un cliente (DELETE)
    @DeleteMapping("/{id}")
    public Response<Cliente> eliminarCliente(@PathVariable Long id) {
        try {
            clienteService.eliminarCliente(id);
            return new Response<>(1, "Datos eliminados", null);
        } catch (Exception e) {
            return new Response<>(0, "No se eliminar datos", null); // Devolvemos un error si no se pudo guardar
        }
    }
}
