package test.cuenta.service.Infrastructure.messaging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

import test.cuenta.service.Domain.model.Cuenta;
import test.cuenta.service.Infrastructure.persistence.CuentaJpaRepository;

public class MessageConsumerTest {

    @Mock
    private CuentaJpaRepository cuentaJpaRepository;

    @InjectMocks
    private MessageConsumer messageConsumer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCrearCuenta() {
        // Simular un objeto Cuenta
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("478758");
        cuenta.setTipoCuenta("Ahorros");
        cuenta.setSaldoInicial(2000D);
        cuenta.setEstado("Activo");
        cuenta.setClienteid(1L);

        // Llamar al método que escucha la cola 'crear-cuenta'
        messageConsumer.crear(cuenta);

        // Verificar que el método save() del repositorio fue llamado con el cuenta
        // correcto
        // probar con microservicio dockerizado
        // verify(cuentaJpaRepository, times(1)).save(cuenta);
    }

    @Test
    public void testActualizarCuenta() {
        // Simular un objeto Cuenta
        // Simular el ID del cuenta a eliminar
        Long cuentaId = 1L;
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("478758");
        cuenta.setTipoCuenta("Ahorros");
        cuenta.setSaldoInicial(2000D);
        cuenta.setEstado("Activo");
        cuenta.setClienteid(cuentaId);

        // Llamar al método que escucha la cola 'actualizar-cuenta'
        messageConsumer.actualizar(cuentaId, cuenta);

        // Verificar que el método save() fue llamado con el cuenta actualizado
        // probar con microservicio dockerizado
        // verify(cuentaJpaRepository, times(1)).save(cuenta);
    }

    @Test
    public void testEliminarCuenta() {
        // Simular el ID del cuenta a eliminar
        Long cuentaId = 1L;

        // Llamar al método que escucha la cola 'eliminar-cuenta'
        messageConsumer.eliminar(cuentaId);

        // Verificar que el método deleteById() fue llamado con el ID correcto
        // probar con microservicio dockerizado
        // verify(cuentaJpaRepository, times(1)).deleteById(cuentaId);
    }
}