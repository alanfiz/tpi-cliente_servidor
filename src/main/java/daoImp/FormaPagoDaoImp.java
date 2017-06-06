package daoImp;

import dao.FormapagoDao;
import model.FormaPago;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(FormapagoDao.class)
public class FormapagoDaoImp extends AbstractJpaDaoImpl<FormaPago,Long> implements FormapagoDao {

}
