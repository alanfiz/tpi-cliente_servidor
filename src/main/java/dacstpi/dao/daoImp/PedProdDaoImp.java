package dacstpi.dao.daoImp;

import dacstpi.dao.ClienteDao;
import dacstpi.dao.PedProdDao;
import dacstpi.model.Cliente;
import dacstpi.model.PedProd;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(PedProdDao.class)
public class PedProdDaoImp extends AbstractJpaDaoImpl<PedProd,Long> implements PedProdDao {


}
