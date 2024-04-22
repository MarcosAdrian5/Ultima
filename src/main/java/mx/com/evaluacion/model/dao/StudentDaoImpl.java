package mx.com.evaluacion.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.com.evaluacion.model.entity.Student;

/*
 * Crear clase repositorio o dao, utilizare la anotacion @Repository
 */

 @Repository
public class StudentDaoImpl implements IStudentDao{

    //Entity Manager y contexto de persistencia
    //Guarda internamente todas las entidades y 
    //utiliza como una cache datos de BD
    @Autowired
    
    private EntityManager em; 

    @Override
    public List<Student> list() {
        return em.createQuery("from Student").getResultList();
    }

    @Override
    public void save(Student student) {
        if (student.getId() != null && student.getId()>0){
            //Actualizo student 
            em.merge(student);
        }else{
            //Creamos nuevo student en la base
            em.persist(student);
        }
    }

    @Override
    public Student getById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public void delete(Long id) {
        Student student = getById(id);
        em.remove(student);
    }
    
}
