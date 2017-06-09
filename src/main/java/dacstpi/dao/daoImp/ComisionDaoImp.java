package dacstpi.dao.daoImp;

import dacstpi.dao.ComisionDao;
import dacstpi.model.Comision;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ComisionDao.class)
public class ComisionDaoImp extends AbstractJpaDaoImpl<Comision,Long> implements ComisionDao {

}
