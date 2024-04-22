package mx.com.evaluacion.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.evaluacion.model.dao.IRegistroComprasOnlineDao;
import mx.com.evaluacion.model.entity.RegistroComprasOnline;

/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service, podemos operar con distintas clases DAO
 */
@Service
public class RegistroComprasOnlineServiceImpl implements IRegistroComprasOnlineService{

    //Inyectamos la interfaz para utilizar los métodos de CRUD
    // C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IRegistroComprasOnlineDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<RegistroComprasOnline> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(RegistroComprasOnline registroComprasOnline) {
        dao.save(registroComprasOnline);
    }   

    @Transactional(readOnly = true)
    @Override
    public RegistroComprasOnline getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

}
