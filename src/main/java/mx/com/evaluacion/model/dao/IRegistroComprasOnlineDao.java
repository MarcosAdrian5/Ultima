package mx.com.evaluacion.model.dao;

import java.util.List;
import mx.com.evaluacion.model.entity.RegistroComprasOnline;

public interface IRegistroComprasOnlineDao {
    List<RegistroComprasOnline>list();
    void save(RegistroComprasOnline regisroComprasOnline);
    RegistroComprasOnline getById(Long id);
    void delete(Long id);
    
}
