package test.cliente.service.Domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "clienteid") // La clave primaria es la de Persona
public class Cliente extends Persona {

    @Column(nullable = false)
    private String contrasenia;

    @Column(nullable = false)
    private Boolean estado;

    // Getters y Setters
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}