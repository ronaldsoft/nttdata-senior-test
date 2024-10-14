package test.cliente.service.Infrastructure.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import test.cliente.service.Domain.model.Cliente;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteJpaRepositoryTest {

    @Autowired
    private ClienteJpaRepository clienteJpaRepository;

    @Test
    public void testGuardarCliente() {
        // Crear un cliente de prueba
        Cliente cliente = new Cliente();
        cliente.setNombre("Carlos");
        cliente.setIdentificacion("1711556547");
        cliente.setTelefono("111222333");
        cliente.setDireccion("Calle del Sol");
        cliente.setContrasenia("123456");
        cliente.setEstado(true);

        // Guardar el cliente
        Cliente clienteGuardado = clienteJpaRepository.guardar(cliente);

        // Verificar que el cliente fue guardado correctamente
        assertThat(clienteGuardado.getId()).isNotNull();
    }

    @Test
    public void testBuscarClientePorId() {
        // Crear y guardar un cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("Ana López");
        cliente.setTelefono("111222333");
        cliente.setIdentificacion("1711556548");
        cliente.setDireccion("Calle del Sol");
        cliente.setContrasenia("123456");
        cliente.setEstado(true);

        Cliente clienteGuardado = clienteJpaRepository.guardar(cliente);

        // Buscar cliente por ID
        Cliente clienteEncontrado = clienteJpaRepository.obtenerPorId(clienteGuardado.getId());

        // Verificar que el cliente fue encontrado
        // assertThat(clienteEncontrado).isPresent();
        assertThat(clienteEncontrado.getNombre()).isEqualTo("Ana López");
    }
}