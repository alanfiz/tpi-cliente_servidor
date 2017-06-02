package daoImp;

import dao.TarjetaDao;
import model.Tarjeta;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(TarjetaDao.class)
public class TarjetaDaoImp extends AbstractJpaDaoImpl<Tarjeta,Long> implements TarjetaDao {


}

