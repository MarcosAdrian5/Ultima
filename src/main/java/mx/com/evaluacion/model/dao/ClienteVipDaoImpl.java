package mx.com.evaluacion.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.com.evaluacion.model.entity.ClienteVip;

/*
 * Crear clase repositorio o dao, utilizare la anotacion @Repository
 */

 @Repository
public class ClienteVipDaoImpl implements IClienteVipDao{

    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidades y 
    //utiliza como una cache datos de BD
    @Autowired
    
    private EntityManager em; 

    @Override
    public List<ClienteVip> list() {
        return em.createQuery("from ClienteVip").getResultList();
    }

    @Override
    public void save(ClienteVip clienteVip) {
        if (clienteVip.getId() != null && clienteVip.getId()>0){
            //Actualizo student 
            em.merge(clienteVip);
        }else{
            //Creamos nuevo student en la base
            em.persist(clienteVip);
        }
    }

    @Override
    public ClienteVip getById(Long id) {
        return em.find(ClienteVip.class, id);
    }

    @Override
    public void delete(Long id) {
        ClienteVip clienteVip = getById(id);
        em.remove(clienteVip);
    }
    
}
