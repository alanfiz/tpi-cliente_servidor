package dacstpi.dao.daoImp;

import dacstpi.dao.FormaPagoDao;
import dacstpi.model.FormaPago;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(FormaPagoDao.class)
public class FormaPagoDaoImp extends AbstractJpaDaoImpl<FormaPago,Long> implements FormaPagoDao {

}
