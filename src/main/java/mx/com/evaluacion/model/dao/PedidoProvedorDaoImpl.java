package mx.com.evaluacion.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.com.evaluacion.model.entity.PedidoProveedor;

/*
 * Crear clase repositorio o dao, utilizare la anotacion @Repository
 */

 @Repository
public class PedidoProvedorDaoImpl implements IPedidoProvedorDao{

    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidades y 
    //utiliza como una cache datos de BD
    @Autowired
    
    private EntityManager em; 

    @Override
    public List<PedidoProveedor> list() {
        return em.createQuery("from PedidoProveedor").getResultList();
    }

    @Override
    public void save(PedidoProveedor pedidoProveedor) {
        if (pedidoProveedor.getId() != null && pedidoProveedor.getId()>0){
            //Actualizo pedido
            em.merge(pedidoProveedor);
        }else{
            //Creamos nuevo pedido en la base
            em.persist(pedidoProveedor);
        }
    }

    @Override
    public PedidoProveedor getById(Long id) {
        return em.find(PedidoProveedor.class, id);
    }

    @Override
    public void delete(Long id) {
        PedidoProveedor pedidoProveedor = getById(id);
        em.remove(pedidoProveedor);
    }
    
}
