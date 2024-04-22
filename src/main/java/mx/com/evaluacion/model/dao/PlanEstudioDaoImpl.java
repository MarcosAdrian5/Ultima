package mx.com.evaluacion.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.com.evaluacion.model.entity.PlanEstudio;

/*
 * Crear clase repositorio o dao, utilizare la anotacion @Repository
 */

 @Repository
public class PlanEstudioDaoImpl implements IPlanEstudioDao{

    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidades y 
    //utiliza como una cache datos de BD
    @Autowired
    
    private EntityManager em; 

    @Override
    public List<PlanEstudio> list() {
        return em.createQuery("from PlanEstudio").getResultList();
    }

    @Override
    public void save(PlanEstudio planEstudio) {
        if (planEstudio.getId() != null && planEstudio.getId()>0){
            //Actualizo pedido
            em.merge(planEstudio);
        }else{
            //Creamos nuevo pedido en la base
            em.persist(planEstudio);
        }
    }

    @Override
    public PlanEstudio getById(Long id) {
        return em.find(PlanEstudio.class, id);
    }

    @Override
    public void delete(Long id) {
        PlanEstudio planEstudio = getById(id);
        em.remove(planEstudio);
    }
    
}
