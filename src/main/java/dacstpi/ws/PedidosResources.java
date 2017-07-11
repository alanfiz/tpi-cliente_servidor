package dacstpi.ws;

import dacstpi.dao.DaoException;
import dacstpi.dao.PedidoDao;
import dacstpi.dao.TarjetaDao;
import dacstpi.model.Cliente;
import dacstpi.model.Pedido;
import dacstpi.model.Tarjeta;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

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
