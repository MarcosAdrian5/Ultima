package mx.com.evaluacion.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    @Column(length = 30)
    private String name;

    @NotEmpty
    @Column(length = 30)
    private String middleName;

    @NotEmpty
    @Column(length = 30)
    private String lastName;

    @Min(value = 0, message = "No puede ser menor que 0")
    @Max(value = 10, message = "No puede ser mayor que 10")
    private Float average;


    @Temporal(TemporalType.DATE)
    private Date recordAt;

    //Registrar la fecha y hora actual
    @PrePersist
    public void prePersist(){
        recordAt = new Date();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Float getAverage() {
        return average;
    }
    public void setAverage(Float average) {
        this.average = average;
    }
   
    public Date getRecordAt() {
        return recordAt;
    }

    public void setRecordAt(Date recordAt) {
        this.recordAt = recordAt;
    }
    
}
