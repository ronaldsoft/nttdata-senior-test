package test.cuenta.service.Domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Clave primaria (PK)

    private String numeroCuenta; // Clave primaria de tipo String

    @Column(nullable = false, length = 50)
    private String tipoCuenta; // Ej. Ahorros, Corriente

    @Column(nullable = false, precision = 15, scale = 2)
    private Double saldoInicial;

    @Column(nullable = false, length = 20)
    private String estado; // Estado de la cuenta (Activo, Inactivo, etc.)

    @Column(nullable = false)
    private Long clienteid; // Relación lógica con Cliente (microservicio separado)

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    @Transient
    private List<Movimiento> movimiento; // Relación de uno a muchos con Movimientos

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getClienteid() {
        return clienteid;
    }

    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }

    public List<Movimiento> getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(List<Movimiento> movimiento) {
        this.movimiento = movimiento;
    }
}