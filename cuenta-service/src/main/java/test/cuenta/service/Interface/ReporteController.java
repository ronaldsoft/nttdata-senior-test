package test.cuenta.service.Interface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import test.cuenta.service.Domain.model.Cliente;
import test.cuenta.service.Domain.model.Cuenta;
import test.cuenta.service.Domain.model.Movimiento;
import test.cuenta.service.Domain.model.Reporte;
import test.cuenta.service.Domain.model.Response;
import test.cuenta.service.Infrastructure.messaging.MessageProducer;
import test.cuenta.service.Infrastructure.persistence.MovimientoRepository;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final MessageProducer messageProducer;
    private final MovimientoRepository movimientoRepository;

    public ReporteController(MessageProducer messageProducer, MovimientoRepository movimientoRepository) {
        this.messageProducer = messageProducer;
        this.movimientoRepository = movimientoRepository;
    }

    @GetMapping
    public Response<Object> generarReporte(@RequestParam String fecha, @RequestParam String clienteId) {
        try {
            // Separar la cadena por la coma
            String[] fechasSeparadas = fecha.split(",");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            // Obtener las fechas
            Date fechaInicio = dateFormat.parse(fechasSeparadas[0]);
            Date fechaFin = dateFormat.parse(fechasSeparadas[1]);
            long id = Long.parseLong(clienteId);
            // Solicitar información del cliente
            String cliente = (String) messageProducer.recibirMensaje("client-queue", clienteId);
            ObjectMapper objectMapper = new ObjectMapper();
            Cliente persona = objectMapper.readValue(cliente, Cliente.class);
            if (cliente == null) {
                return new Response<>(0, "No existe el cliente", null);
            }

            List<Movimiento> movimientos = movimientoRepository.findByCuenta_ClienteidAndFechaBetween(id, fechaInicio,
                    fechaFin);

            // Crear el reporte con la información del cliente y los movimientos
            List<Reporte> reportes = movimientos.stream().map(movimiento -> {
                Cuenta cuenta = movimiento.getCuenta(); // Suponiendo que Movimiento tiene una referencia a Cuenta
                return new Reporte(
                        movimiento.getFecha(),
                        persona.getNombre(),
                        cuenta.getNumeroCuenta(),
                        cuenta.getTipoCuenta(),
                        cuenta.getSaldoInicial(),
                        cuenta.getEstado(),
                        movimiento.getValor(),
                        (cuenta.getSaldoInicial() + movimiento.getValor()));
            }).collect(Collectors.toList());
            return new Response<>(1, "Lista de movimientos", Optional.of(reportes));
        } catch (Exception e) {
            // System.err.println(e.getMessage());
            return new Response<>(0, e.getMessage(), null); // Devolvemos un error si no se pudo guardar
        }
    }
}
