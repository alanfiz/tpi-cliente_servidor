package dacstpi.dao.daoImp;

import dacstpi.dao.ProdComDao;
import dacstpi.model.ProdCom;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ProdComDao.class)
public class ProdComDaoImp extends AbstractJpaDaoImpl<ProdCom,Long> implements ProdComDao {


}
