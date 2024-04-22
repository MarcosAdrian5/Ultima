package mx.com.evaluacion.model.service;



import java.util.List;

import mx.com.evaluacion.model.entity.RegistroComprasOnline;

public interface IRegistroComprasOnlineService {
    List<RegistroComprasOnline>list();
    void save(RegistroComprasOnline registroComprasOnline);
    RegistroComprasOnline getById(Long id);
    void delete(Long id);    
}
