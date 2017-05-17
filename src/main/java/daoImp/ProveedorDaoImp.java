package daoImp;

import dao.ProveedorDao;
import model.Proveedor;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ProveedorDao.class)
public class ProveedorDaoImp extends AbstractJpaDaoImpl<Proveedor,Integer> implements ProveedorDao {


}

