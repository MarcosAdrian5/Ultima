package mx.com.evaluacion.model.dao;

import java.util.List;

import mx.com.evaluacion.model.entity.ClienteVip;


public interface IClienteVipDao {
    List<ClienteVip>list();
    void save(ClienteVip clienteVip);
    ClienteVip getById(Long id);
    void delete(Long id);
    
}
