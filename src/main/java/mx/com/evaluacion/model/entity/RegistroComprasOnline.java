package mx.com.evaluacion.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotEmpty;

@Entity
public class RegistroComprasOnline {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @NotEmpty
    @Column(length = 30)
    private String fechaCompra;

    @NotEmpty
    @Column(length = 30)
    private String producto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    
}
