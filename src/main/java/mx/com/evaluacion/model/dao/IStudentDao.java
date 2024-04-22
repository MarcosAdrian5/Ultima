package mx.com.evaluacion.model.dao;

import java.util.List;

import mx.com.evaluacion.model.entity.Student;

public interface IStudentDao {
    List<Student>list();
    void save(Student student);
    Student getById(Long id);
    void delete(Long id);
    
}
