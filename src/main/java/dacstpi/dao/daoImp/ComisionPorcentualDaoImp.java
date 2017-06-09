package dacstpi.dao.daoImp;

import dacstpi.dao.ComisionPorcentualDao;
import dacstpi.model.ComisionPorcentual;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ComisionPorcentualDao.class)
public class ComisionPorcentualDaoImp extends AbstractJpaDaoImpl<ComisionPorcentual,Long> implements ComisionPorcentualDao {

}
