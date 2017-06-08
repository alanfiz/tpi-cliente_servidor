package dao.daoImp;

import dao.ComisionFijaDao;
import model.ComisionFija;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ComisionFijaDao.class)
public class ComisionFijaDaoImp extends AbstractJpaDaoImpl<ComisionFija,Long> implements ComisionFijaDao {
}
