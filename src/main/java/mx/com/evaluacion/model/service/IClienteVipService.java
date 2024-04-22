package mx.com.evaluacion.model.service;
import java.util.List;

import mx.com.evaluacion.model.entity.ClienteVip;

public interface IClienteVipService {
    List<ClienteVip>list();
    void save(ClienteVip clienteVip);
    ClienteVip getById(Long id);
    void delete(Long id);    
}
