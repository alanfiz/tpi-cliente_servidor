package dacstpi.dao.daoImp;



import dacstpi.dao.DaoException;
import dacstpi.dao.UserRolDao;
import dacstpi.model.UserRol;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(UserRolDao.class)
public class UserRolDaoImp extends AbstractJpaDaoImpl<UserRol,Long> implements UserRolDao {




}