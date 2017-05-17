package daoImp;

import dao.ClienteDao;
import model.Cliente;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ClienteDao.class)
public class ClienteDaoImp extends AbstractJpaDaoImpl<Cliente,Integer> implements ClienteDao {


}
