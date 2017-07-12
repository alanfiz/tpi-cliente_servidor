package dacstpi.dao.daoImp;

import dacstpi.dao.AdministradorDao;
import dacstpi.model.Administrador;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(AdministradorDao.class)
public class AdministradorDaoImp extends AbstractJpaDaoImpl<Administrador,Long> implements AdministradorDao {



}