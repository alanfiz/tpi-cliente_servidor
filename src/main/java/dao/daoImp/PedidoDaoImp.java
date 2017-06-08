package dao.daoImp;

import dao.PedidoDao;
import model.Pedido;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(PedidoDao.class)
public class PedidoDaoImp extends AbstractJpaDaoImpl<Pedido,Long> implements PedidoDao {


}

