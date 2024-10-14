package test.cuenta.service.Infrastructure.persistence;

import java.util.Date;
import java.util.List;

import test.cuenta.service.Domain.model.Movimiento;

public interface MovimientoRepository {
    Movimiento guardar(Movimiento cuenta);

    Movimiento obtenerPorId(Long id);

    List<Movimiento> obtenerTodosLosMovimientos();

    List<Movimiento> findByCuenta_ClienteidAndFechaBetween(Long clientid, Date fechaInicio, Date fechaFin);

    Movimiento actualizarMovimiento(Long id, Movimiento cuentaDetalles);

    void eliminarMovimiento(Long id);
}