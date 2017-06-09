package dacstpi.dao.daoImp;

import dacstpi.dao.PedidoDao;
import dacstpi.model.Pedido;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(PedidoDao.class)
public class PedidoDaoImp extends AbstractJpaDaoImpl<Pedido,Long> implements PedidoDao {


}

