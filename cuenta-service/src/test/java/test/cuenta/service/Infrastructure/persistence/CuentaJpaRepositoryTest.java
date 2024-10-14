package test.cuenta.service.Infrastructure.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import test.cuenta.service.Domain.model.Cuenta;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CuentaJpaRepositoryTest {

    @Autowired
    private CuentaJpaRepository cuentaJpaRepository;

    @Test
    public void testGuardarCuenta() {
        // Crear un cuenta de prueba
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("478344");
        cuenta.setTipoCuenta("Ahorros");
        cuenta.setSaldoInicial(2000D);
        cuenta.setEstado("Activo");
        cuenta.setClienteid(1L);

        // Guardar el cuenta
        Cuenta cuentaGuardado = cuentaJpaRepository.guardar(cuenta);

        // Verificar que el cuenta fue guardado correctamente
        assertThat(cuentaGuardado.getId()).isNotNull();
    }

    @Test
    public void testBuscarCuentaPorId() {
        // Crear y guardar un cuenta
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta("478323");
        cuenta.setTipoCuenta("Ahorros");
        cuenta.setSaldoInicial(2000D);
        cuenta.setEstado("Activo");
        cuenta.setClienteid(1L);

        Cuenta cuentaGuardado = cuentaJpaRepository.guardar(cuenta);

        // Buscar cuenta por ID
        Cuenta cuentaEncontrado = cuentaJpaRepository.obtenerPorId(cuentaGuardado.getId());

        // Verificar que el cuenta fue encontrado
        // assertThat(cuentaEncontrado).isPresent();
        assertThat(cuentaEncontrado.getNumeroCuenta()).isEqualTo("478323");
    }
}