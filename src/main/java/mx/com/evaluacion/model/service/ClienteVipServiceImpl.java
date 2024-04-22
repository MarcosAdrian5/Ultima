package mx.com.evaluacion.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.evaluacion.model.dao.IClienteVipDao;
import mx.com.evaluacion.model.entity.ClienteVip;


/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service, podemos operar con distintas clases DAO
 */
@Service
public class ClienteVipServiceImpl implements IClienteVipService{

    //Inyectamos la interfaz para utilizar los métodos de CRUD
    // C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IClienteVipDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<ClienteVip> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(ClienteVip clienteVip) {
        dao.save(clienteVip);
    }   

    @Transactional(readOnly = true)
    @Override
    public ClienteVip getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

}
