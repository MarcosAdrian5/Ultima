package mx.com.evaluacion.model.service;



import java.util.List;

import mx.com.evaluacion.model.entity.PlanEstudio;

public interface IPlanEstudioService {
    List<PlanEstudio>list();
    void save(PlanEstudio planEstudio);
    PlanEstudio getById(Long id);
    void delete(Long id);    
}
