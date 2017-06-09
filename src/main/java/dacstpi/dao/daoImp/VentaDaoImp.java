package dacstpi.dao.daoImp;

import dacstpi.dao.VentaDao;
import dacstpi.model.Venta;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(VentaDao.class)
public class VentaDaoImp extends AbstractJpaDaoImpl<Venta,Long> implements VentaDao {


}

