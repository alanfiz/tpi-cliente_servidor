package dacstpi.ws;

import dacstpi.dao.DaoException;
import dacstpi.dao.PedidoDao;
import dacstpi.model.Pedido;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Date;

@Path("pedido")
public class PedidosResources {

    @EJB
    private PedidoDao dao;


    @GET
//    @Consumes("application/json; charset=UTF-8")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    @Produces(MediaType.TEXT_PLAIN)
    public String setPedido(@QueryParam("estadoPedido") String estadoPedido)
    {
        Pedido pedido = new Pedido();
        pedido.setFechayhoraPedido(new Date());
        pedido.setEstadoPedido(estadoPedido);
        try {
            dao.persist(pedido);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }
}
