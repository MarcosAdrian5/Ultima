package mx.com.evaluacion.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.com.evaluacion.model.entity.BitacoraEntrenamiento;


/*
 * Crear clase repositorio o dao, utilizare la anotacion @Repository
 */

 @Repository
public class BitacoraEntrenamientoDaoImpl implements IBitacoraEntrenamientoDao{

    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidades y 
    //utiliza como una cache datos de BD
    @Autowired
    
    private EntityManager em; 

    @Override
    public List<BitacoraEntrenamiento> list() {
        return em.createQuery("from BitacoraEntrenamiento").getResultList();
    }

    @Override
    public void save(BitacoraEntrenamiento bitacoraEntrenamiento) {
        if (bitacoraEntrenamiento.getId() != null && bitacoraEntrenamiento.getId()>0){
            //Actualizo pedido
            em.merge(bitacoraEntrenamiento);
        }else{
            //Creamos nuevo pedido en la base
            em.persist(bitacoraEntrenamiento);
        }
    }

    @Override
    public BitacoraEntrenamiento getById(Long id) {
        return em.find(BitacoraEntrenamiento.class, id);
    }

    @Override
    public void delete(Long id) {
        BitacoraEntrenamiento bitacoraEntrenamiento = getById(id);
        em.remove(bitacoraEntrenamiento);
    }
    
}
