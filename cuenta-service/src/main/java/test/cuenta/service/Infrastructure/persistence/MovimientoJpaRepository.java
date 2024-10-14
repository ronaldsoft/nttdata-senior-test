package test.cuenta.service.Infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.cuenta.service.Domain.model.Movimiento;

@Repository
public interface MovimientoJpaRepository extends JpaRepository<Movimiento, Long>, MovimientoRepository {
    // funciones crud en el repositorio
    @Override
    default Movimiento guardar(Movimiento movimiento) {
        return save(movimiento);
    }

    @Override
    default Movimiento obtenerPorId(Long id) {
        return findById(id).orElse(null);
    }

    @Override
    default List<Movimiento> obtenerTodosLosMovimientos() {
        return findAll();
    }

    @Override
    default Movimiento actualizarMovimiento(Long id, Movimiento movimientoDetalles) {
        Movimiento movimientoExistente = findById(id)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        movimientoExistente.setSaldo(movimientoDetalles.getSaldo());
        movimientoExistente.setTipoMovimiento(movimientoDetalles.getTipoMovimiento());
        movimientoExistente.setValor(movimientoDetalles.getValor());
        // System.err.println(movimientoExistente.getCuenta().getSaldoInicial());
        return save(movimientoExistente);
        // return null;
    }

    @Override
    default void eliminarMovimiento(Long id) {
        deleteById(id);
    }
}
