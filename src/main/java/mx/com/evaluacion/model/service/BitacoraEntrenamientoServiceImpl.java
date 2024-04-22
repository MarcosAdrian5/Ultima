package mx.com.evaluacion.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.evaluacion.model.dao.IBitacoraEntrenamientoDao;
import mx.com.evaluacion.model.entity.BitacoraEntrenamiento;


/*
 * Una clase service, esta basada en el patrón de diseño fachada
 * Es un único punto de acceso hacia los DAOs. Dentro de la clase
 * service, podemos operar con distintas clases DAO
 */
@Service
public class BitacoraEntrenamientoServiceImpl implements IBitacoraEntrenamientoService{

    //Inyectamos la interfaz para utilizar los métodos de CRUD
    // C-Create, R-Read Retrieve, U-Update, D-Delete
    @Autowired
    private IBitacoraEntrenamientoDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<BitacoraEntrenamiento> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(BitacoraEntrenamiento bitacoraEntrenamiento) {
        dao.save(bitacoraEntrenamiento);
    }   

    @Transactional(readOnly = true)
    @Override
    public BitacoraEntrenamiento getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

}
