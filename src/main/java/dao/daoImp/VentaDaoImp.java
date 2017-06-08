package dao.daoImp;

import dao.VentaDao;
import model.Venta;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(VentaDao.class)
public class VentaDaoImp extends AbstractJpaDaoImpl<Venta,Long> implements VentaDao {


}

