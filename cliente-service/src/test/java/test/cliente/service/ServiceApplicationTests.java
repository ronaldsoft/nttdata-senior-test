package test.cliente.service;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import test.cliente.service.Application.service.ClienteService;
import test.cliente.service.Domain.model.Cliente;

@SpringBootTest
class ProofApplicationTests {

	@Test
	void contextLoads() {
	}

	// prueba de integracion crear persona
	@Autowired
	private ClienteService clienteService;

	@Test
	@Rollback(false) // Evita que la prueba sea revertida si es exitosa (opcional)
	public void testCrearUsuario() {
		// Crear un cliente de prueba
		Cliente cliente = new Cliente();
		cliente.setNombre("Carlos");
		cliente.setTelefono("111222333");
		cliente.setIdentificacion("1711556512");
		cliente.setDireccion("Calle del Sol");
		cliente.setContrasenia("123456");
		cliente.setEstado(true);

		// Llamar al servicio que guarda el usuario en la base de datos
		Cliente clienteGuardado = clienteService.crearCliente(cliente);

		// Verificar que el usuario fue guardado correctamente
		assertThat(clienteGuardado.getId()).isNotNull(); // El ID debe ser generado
		assertThat(clienteGuardado.getNombre()).isEqualTo("Carlos");
		assertThat(clienteGuardado.getTelefono()).isEqualTo("111222333");
	}
}