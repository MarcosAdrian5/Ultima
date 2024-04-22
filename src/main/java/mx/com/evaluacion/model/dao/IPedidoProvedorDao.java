package mx.com.evaluacion.model.dao;

import java.util.List;

import mx.com.evaluacion.model.entity.PedidoProveedor;

public interface IPedidoProvedorDao {
    List<PedidoProveedor>list();
    void save(PedidoProveedor pedidoProveedor);
    PedidoProveedor getById(Long id);
    void delete(Long id);
    
}
