package dacstpi.dao.daoImp;

import dacstpi.dao.ProveedorDao;
import dacstpi.model.Proveedor;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ProveedorDao.class)
public class ProveedorDaoImp extends AbstractJpaDaoImpl<Proveedor,Long> implements ProveedorDao {


}

