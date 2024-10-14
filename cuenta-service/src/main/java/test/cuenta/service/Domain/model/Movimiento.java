package test.cuenta.service.Domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
// @JsonIgnoreProperties({ "cuenta" })
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Clave primaria, autogenerada

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fecha;

    @Column(nullable = false, length = 50)
    private String tipoMovimiento; // Ej. Débito, Crédito

    @Column(nullable = false, precision = 15, scale = 2)
    private Double valor;

    @Column(nullable = false, precision = 15, scale = 2)
    private Double saldo; // Saldo después del movimiento

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numeroCuenta", referencedColumnName = "numeroCuenta", nullable = false)
    // Relación con Cuenta
    private Cuenta cuenta; // Relación de muchos a uno con Cuenta

    // Método persistir para asignar la fecha actual
    @PrePersist
    protected void onCreate() {
        this.fecha = new Date(); // Asigna la fecha y hora actual
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}