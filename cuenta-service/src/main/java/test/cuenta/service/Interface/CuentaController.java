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

import test.cuenta.service.Application.service.CuentaService;
import test.cuenta.service.Domain.model.Cuenta;
import test.cuenta.service.Domain.model.Response;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    // inyeccion de servicios
    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping
    public Response<Cuenta> crearCuenta(@RequestBody Cuenta cuenta) {
        try {
            Cuenta cuentaGuardado = cuentaService.crearCuenta(cuenta);
            return new Response<>(1, "Datos guardados", Optional.of(cuentaGuardado));
        } catch (Exception e) {
            return new Response<>(0, "No se pudo crear cuenta", null); // Devolvemos un error si no se pudo guardar
        }
    }

    @GetMapping("/{id}")
    public Response<Cuenta> obtenerCuentaPorId(@PathVariable Long id) {
        try {
            Cuenta cuentaPorId = cuentaService.obtenerCuentaPorId(id);
            return new Response<>(1, "Consulta exitosa", Optional.of(cuentaPorId));
        } catch (Exception e) {
            return new Response<>(0, "No se pudo obtener datos", null); // Devolvemos un error si no se pudo guardar
        }
    }

    // Obtener todos los cuentas (GET)
    @GetMapping
    public Response<List<Cuenta>> obtenerTodosLosCuentas() {
        try {
            List<Cuenta> cuentas = cuentaService.obtenerTodosLasCuentas();
            if (cuentas.isEmpty()) {
                return new Response<>(0, "No se encontraron datos", null); // No hay datos
            } else {
                return new Response<>(1, "Datos encontrados", Optional.of(cuentas)); // Datos encontrados
            }
        } catch (Exception e) {
            return new Response<>(0, "No se pudo obtener datos", null); // Devolvemos un error si no se pudo guardar
        }
    }

    // Actualizar un cuenta (PUT)
    @PutMapping("/{numeroCuenta}")
    public Response<Cuenta> actualizarCuenta(@PathVariable Long numeroCuenta, @RequestBody Cuenta cuentaDetalles) {
        try {
            Cuenta cuentaGuardado = cuentaService.actualizarCuenta(numeroCuenta, cuentaDetalles);
            return new Response<>(1, "Datos actualizados", Optional.of(cuentaGuardado));
        } catch (Exception e) {
            return new Response<>(0, "No se actualizar datos", null); // Devolvemos un error si no se pudo guardar
        }
    }

    // Eliminar un cuenta (DELETE)
    @DeleteMapping("/{id}")
    public Response<Cuenta> eliminarCuenta(@PathVariable Long id) {
        try {
            cuentaService.eliminarCuenta(id);
            return new Response<>(1, "Datos eliminados", null);
        } catch (Exception e) {
            return new Response<>(0, "No se eliminar datos", null); // Devolvemos un error si no se pudo guardar
        }
    }
}
