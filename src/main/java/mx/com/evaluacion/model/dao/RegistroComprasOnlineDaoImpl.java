package mx.com.evaluacion.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.com.evaluacion.model.entity.RegistroComprasOnline;

/*
 * Crear clase repositorio o dao, utilizare la anotacion @Repository
 */

 @Repository
public class RegistroComprasOnlineDaoImpl implements IRegistroComprasOnlineDao{

    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidades y 
    //utiliza como una cache datos de BD
    @Autowired
    
    private EntityManager em; 

    @Override
    public List<RegistroComprasOnline> list() {
        return em.createQuery("from RegistroComprasOnline").getResultList();
    }

    @Override
    public void save(RegistroComprasOnline regisroComprasOnline) {
        if (regisroComprasOnline.getId() != null && regisroComprasOnline.getId()>0){
            //Actualizo pedido
            em.merge(regisroComprasOnline);
        }else{
            //Creamos nuevo pedido en la base
            em.persist(regisroComprasOnline);
        }
    }

    @Override
    public RegistroComprasOnline getById(Long id) {
        return em.find(RegistroComprasOnline.class, id);
    }

    @Override
    public void delete(Long id) {
        RegistroComprasOnline regisroComprasOnline = getById(id);
        em.remove(regisroComprasOnline);
    }
    
}
