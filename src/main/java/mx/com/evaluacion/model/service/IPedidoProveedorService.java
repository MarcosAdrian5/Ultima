package mx.com.evaluacion.model.service;



import java.util.List;

import mx.com.evaluacion.model.entity.PedidoProveedor;

public interface IPedidoProveedorService {
    List<PedidoProveedor>list();
    void save(PedidoProveedor pedidoProveedor);
    PedidoProveedor getById(Long id);
    void delete(Long id);    
}
