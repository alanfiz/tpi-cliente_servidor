package daoImp;

import dao.ComisionDao;
import model.Comision;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ComisionDao.class)
public class ComisionDaoImp extends AbstractJpaDaoImpl<Comision,Integer> implements ComisionDao {

}
