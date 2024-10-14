package test.cuenta.service.Infrastructure.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

import test.cuenta.service.Domain.model.Cuenta;
import test.cuenta.service.Infrastructure.persistence.CuentaJpaRepository;

public class MessageConsumer {
    private final CuentaJpaRepository cuentaJpaRepository;

    public MessageConsumer(CuentaJpaRepository cuentaJpaRepository) {
        this.cuentaJpaRepository = cuentaJpaRepository;
    }

    // Consumidor para crear cuentas
    @RabbitListener(queues = "crear-cuenta")
    public void crear(Cuenta cuenta) {
        cuentaJpaRepository.guardar(cuenta);
        System.out.println("Cuenta creado: " + cuenta.getId());
    }

    // Consumidor para actualizar cuentas
    @RabbitListener(queues = "actualizar-cuenta")
    public void actualizar(Long cuentaId, Cuenta cuenta) {
        cuentaJpaRepository.actualizarCuenta(cuentaId, cuenta);
        System.out.println("Cuenta actualizado: " + cuenta.getId());
    }

    // Consumidor para eliminar cuentas
    @RabbitListener(queues = "eliminar-cuenta")
    public void eliminar(Long cuentaId) {
        cuentaJpaRepository.eliminarCuenta(cuentaId);
        System.out.println("Cuenta eliminado: " + cuentaId);
    }
}