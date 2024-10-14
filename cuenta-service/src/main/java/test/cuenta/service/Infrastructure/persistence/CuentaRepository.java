package test.cuenta.service.Infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import test.cuenta.service.Domain.model.Cuenta;

public interface CuentaRepository {
    Cuenta guardar(Cuenta cuenta);

    Cuenta obtenerPorId(Long id);

    List<Cuenta> obtenerTodosLasCuentas();

    Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);

    Cuenta actualizarCuenta(Long id, Cuenta cuentaDetalles);

    void eliminarCuenta(Long id);
}
