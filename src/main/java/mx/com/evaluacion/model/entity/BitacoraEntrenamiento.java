package mx.com.evaluacion.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotEmpty;

@Entity
public class BitacoraEntrenamiento {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @NotEmpty
    @Column(length = 30)
    private String fecha;

    @NotEmpty
    @Column(length = 30)
    private String actividad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

   
    
    
}
