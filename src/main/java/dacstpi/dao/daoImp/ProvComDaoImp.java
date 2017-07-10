package dacstpi.dao.daoImp;

import dacstpi.dao.ProvComDao;
import dacstpi.model.ProvCom;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ProvComDao.class)
public class ProvComDaoImp extends AbstractJpaDaoImpl<ProvCom,Long> implements ProvComDao {


}
