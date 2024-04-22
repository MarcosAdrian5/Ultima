package mx.com.evaluacion.model.dao;

import java.util.List;

import mx.com.evaluacion.model.entity.BitacoraEntrenamiento;

public interface IBitacoraEntrenamientoDao {
    List<BitacoraEntrenamiento>list();
    void save(BitacoraEntrenamiento bitacoraEntrenamiento);
    BitacoraEntrenamiento getById(Long id);
    void delete(Long id);
    
}
