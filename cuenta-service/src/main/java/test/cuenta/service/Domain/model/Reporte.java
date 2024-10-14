package test.cuenta.service.Domain.model;

import java.util.Date;

public class Reporte {

    private Date fecha;
    private String cliente;
    private String numeroCuenta;
    private String tipo;
    private Double saldoInicial;
    private String estado;
    private Double movimiento;
    private Double saldoDisponible;

    // Constructor, getters y setters
    // Constructor con parámetros
    public Reporte(Date fecha, String cliente, String numeroCuenta, String tipo,
            Double saldoInicial, String estado, Double movimiento, Double saldoDisponible) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.movimiento = movimiento;
        this.saldoDisponible = saldoDisponible;
    }

    // Getter para fecha
    public Date getFecha() {
        return fecha;
    }

    // Setter para fecha
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // Getter para cliente
    public String getCliente() {
        return cliente;
    }

    // Setter para cliente
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    // Getter para numeroCuenta
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    // Setter para numeroCuenta
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    // Getter para tipo
    public String getTipo() {
        return tipo;
    }

    // Setter para tipo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter para saldoInicial
    public Double getSaldoInicial() {
        return saldoInicial;
    }

    // Setter para saldoInicial
    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    // Getter para estado
    public String getEstado() {
        return estado;
    }

    // Setter para estado
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Getter para movimiento
    public Double getMovimiento() {
        return movimiento;
    }

    // Setter para movimiento
    public void setMovimiento(Double movimiento) {
        this.movimiento = movimiento;
    }

    // Getter para saldoDisponible
    public Double getSaldoDisponible() {
        return saldoDisponible;
    }

    // Setter para saldoDisponible
    public void setSaldoDisponible(Double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
}