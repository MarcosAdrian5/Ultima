package mx.com.evaluacion.model.service;



import java.util.List;

import mx.com.evaluacion.model.entity.BitacoraEntrenamiento;

public interface IBitacoraEntrenamientoService {
    List<BitacoraEntrenamiento>list();
    void save(BitacoraEntrenamiento bitacoraEntrenamiento);
    BitacoraEntrenamiento getById(Long id);
    void delete(Long id);    
}
