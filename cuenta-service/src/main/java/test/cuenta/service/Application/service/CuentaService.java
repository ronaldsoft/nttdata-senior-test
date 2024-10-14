package test.cuenta.service.Application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import test.cuenta.service.Domain.model.Cuenta;
import test.cuenta.service.Infrastructure.persistence.CuentaRepository;

@Service
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaService(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    public Cuenta crearCuenta(Cuenta cliente) {
        return cuentaRepository.guardar(cliente);
    }

    public Cuenta obtenerCuentaPorId(Long id) {
        return cuentaRepository.obtenerPorId(id);
    }

    // Leer todos los clientes
    public List<Cuenta> obtenerTodosLasCuentas() {
        return cuentaRepository.obtenerTodosLasCuentas();
    }

    // Actualizar un cliente
    public Cuenta actualizarCuenta(Long id, Cuenta cuentaDetalles) {
        return cuentaRepository.actualizarCuenta(id, cuentaDetalles);
    }

    // Eliminar un cliente
    public void eliminarCuenta(Long id) {
        cuentaRepository.eliminarCuenta(id);
    }
}