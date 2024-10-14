package test.cuenta.service.Infrastructure.persistence;

import java.util.List;

import test.cuenta.service.Domain.model.Movimiento;

public interface MovimientoRepository {
    Movimiento guardar(Movimiento cuenta);

    Movimiento obtenerPorId(Long id);

    List<Movimiento> obtenerTodosLosMovimientos();

    Movimiento actualizarMovimiento(Long id, Movimiento cuentaDetalles);

    void eliminarMovimiento(Long id);
}