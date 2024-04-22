package mx.com.evaluacion.model.dao;

import java.util.List;

import mx.com.evaluacion.model.entity.PlanEstudio;

public interface IPlanEstudioDao {
    List<PlanEstudio>list();
    void save(PlanEstudio planEstudio);
    PlanEstudio getById(Long id);
    void delete(Long id);
    
}
