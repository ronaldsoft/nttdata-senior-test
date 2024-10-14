package test.cuenta.service.Interface;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.cuenta.service.Application.service.MovimientoService;
import test.cuenta.service.Domain.model.Movimiento;
import test.cuenta.service.Domain.model.Response;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    // inyeccion de servicios
    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @PostMapping
    public Response<Movimiento> crearMovimiento(@RequestBody Movimiento movimiento) {
        try {
            Movimiento movimientoGuardado = movimientoService.crearMovimiento(movimiento);
            return new Response<>(1, "Datos guardados", Optional.of(movimientoGuardado));
        } catch (Exception e) {
            // System.err.println(e.getMessage());
            return new Response<>(0, e.getMessage(), null); // Devolvemos un error si no se pudo guardar
        }
    }

    @GetMapping("/{id}")
    public Response<Movimiento> obtenerMovimientoPorId(@PathVariable Long id) {
        try {
            Movimiento movimientoPorId = movimientoService.obtenerMovimientoPorId(id);
            return new Response<>(1, "Consulta exitosa", Optional.of(movimientoPorId));
        } catch (Exception e) {
            return new Response<>(0, "No se pudo obtener datos", null); // Devolvemos un error si no se pudo guardar
        }
    }

    // Obtener todos los movimientos (GET)
    @GetMapping
    public Response<List<Movimiento>> obtenerTodosLosMovimientos() {
        try {
            List<Movimiento> movimientos = movimientoService.obtenerTodosLosMovimientos();
            if (movimientos.isEmpty()) {
                return new Response<>(0, "No se encontraron datos", null); // No hay datos
            } else {
                return new Response<>(1, "Datos encontrados", Optional.of(movimientos)); // Datos encontrados
            }
        } catch (Exception e) {
            return new Response<>(0, "No se pudo obtener datos", null); // Devolvemos un error si no se pudo guardar
        }
    }

    // Actualizar un movimiento (PUT)
    @PutMapping("/{id}")
    public Response<Movimiento> actualizarMovimiento(@PathVariable Long id,
            @RequestBody Movimiento movimientoDetalles) {
        try {
            Movimiento movimientoGuardado = movimientoService.actualizarMovimiento(id,
                    movimientoDetalles);
            return new Response<>(1, "Datos actualizados", Optional.of(movimientoGuardado));
        } catch (Exception e) {
            return new Response<>(0, "No se actualizar datos", null); // Devolvemos un error si no se pudo guardar
        }
    }

    // Eliminar un movimiento (DELETE)
    @DeleteMapping("/{id}")
    public Response<Movimiento> eliminarMovimiento(@PathVariable Long id) {
        try {
            movimientoService.eliminarMovimiento(id);
            return new Response<>(1, "Datos eliminados", null);
        } catch (Exception e) {
            return new Response<>(0, "No se eliminar datos", null); // Devolvemos un error si no se pudo guardar
        }
    }
}