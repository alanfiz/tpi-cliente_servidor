package dao.daoImp;

import dao.ProductoDao;
import model.Producto;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ProductoDao.class)
public class ProductoDaoImp extends AbstractJpaDaoImpl<Producto,Long> implements ProductoDao {


}
