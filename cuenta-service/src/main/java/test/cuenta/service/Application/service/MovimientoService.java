package test.cuenta.service.Application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import test.cuenta.service.Domain.model.Cuenta;
import test.cuenta.service.Domain.model.Movimiento;
import test.cuenta.service.Infrastructure.persistence.CuentaRepository;
import test.cuenta.service.Infrastructure.persistence.MovimientoRepository;

@Service
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final CuentaRepository cuentaRepository;

    public MovimientoService(MovimientoRepository movimientoRepository, CuentaRepository cuentaRepository) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaRepository = cuentaRepository;
    }

    public Movimiento crearMovimiento(Movimiento movimiento) throws Exception {
        Cuenta cuenta = cuentaRepository.findByNumeroCuenta(movimiento.getCuenta().getNumeroCuenta())
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        if (movimiento.getValor() == 0) {
            throw new Exception("El valor no puede ser 0");
        }
        if (cuenta.getSaldoInicial() <= 0 && "Retiro".equals(movimiento.getTipoMovimiento())) {
            throw new Exception("Saldo no disponible");
        }
        if (movimiento.getValor() > cuenta.getSaldoInicial()
                && "Retiro".equals(movimiento.getTipoMovimiento())) {
            throw new Exception("Saldo no disponible");
        }
        Double saldoCuenta = cuenta.getSaldoInicial();

        if ("Retiro".equals(movimiento.getTipoMovimiento())) {
            saldoCuenta -= movimiento.getValor();
        }

        if ("Deposito".equals(movimiento.getTipoMovimiento())) {
            saldoCuenta += movimiento.getValor();
        }

        System.err.println(saldoCuenta);
        cuenta.setSaldoInicial(saldoCuenta);
        // Asignar saldo al movimiento
        movimiento.setSaldo(cuenta.getSaldoInicial());
        // Asignar la cuenta al movimiento
        movimiento.setCuenta(cuenta);
        cuentaRepository.actualizarCuenta(cuenta.getId(), cuenta);
        return movimientoRepository.guardar(movimiento);
    }

    public Movimiento obtenerMovimientoPorId(Long id) {
        return movimientoRepository.obtenerPorId(id);
    }

    // Leer todos los clientes
    public List<Movimiento> obtenerTodosLosMovimientos() {
        return movimientoRepository.obtenerTodosLosMovimientos();
    }

    // Actualizar un cliente
    public Movimiento actualizarMovimiento(Long id, Movimiento movimientoDetalles) {
        return movimientoRepository.actualizarMovimiento(id, movimientoDetalles);
    }

    // Eliminar un cliente
    public void eliminarMovimiento(Long id) {
        movimientoRepository.eliminarMovimiento(id);
    }
}