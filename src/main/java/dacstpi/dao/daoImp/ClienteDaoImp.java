package dacstpi.dao.daoImp;

import dacstpi.dao.ClienteDao;
import dacstpi.model.Cliente;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ClienteDao.class)
public class ClienteDaoImp extends AbstractJpaDaoImpl<Cliente,Long> implements ClienteDao {


}
