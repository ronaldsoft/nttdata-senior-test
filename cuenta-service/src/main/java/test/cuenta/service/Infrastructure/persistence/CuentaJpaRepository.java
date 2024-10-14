package test.cuenta.service.Infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.cuenta.service.Domain.model.Cuenta;

@Repository
public interface CuentaJpaRepository extends JpaRepository<Cuenta, Long>, CuentaRepository {
    // funciones crud en el repositorio
    @Override
    default Cuenta guardar(Cuenta cuenta) {
        return save(cuenta);
    }

    @Override
    default Cuenta obtenerPorId(Long id) {
        return findById(id).orElse(null);
    }

    @Override
    default List<Cuenta> obtenerTodosLasCuentas() {
        return findAll();
    }

    // Buscar Cuenta por numeroCuenta
    @Override
    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

    @Override
    default Cuenta actualizarCuenta(Long id, Cuenta cuentaDetalles) {
        Cuenta cuentaExistente = findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrado"));
        cuentaExistente.setTipoCuenta(cuentaDetalles.getTipoCuenta());
        cuentaExistente.setSaldoInicial(cuentaDetalles.getSaldoInicial());
        cuentaExistente.setEstado(cuentaDetalles.getEstado());
        cuentaExistente.setClienteid(cuentaDetalles.getClienteid());

        return save(cuentaExistente);
    }

    @Override
    default void eliminarCuenta(Long id) {
        deleteById(id);
    }
}
