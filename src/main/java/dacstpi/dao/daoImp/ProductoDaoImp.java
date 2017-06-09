package dacstpi.dao.daoImp;

import dacstpi.dao.ProductoDao;
import dacstpi.model.Producto;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ProductoDao.class)
public class ProductoDaoImp extends AbstractJpaDaoImpl<Producto,Long> implements ProductoDao {


}

