package mx.com.evaluacion.model.service;



import java.util.List;

import mx.com.evaluacion.model.entity.Student;

public interface IStudenService {
    List<Student>list();
    void save(Student student);
    Student getById(Long id);
    void delete(Long id);    
}
