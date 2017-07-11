package dacstpi.ws;

import dacstpi.beans.MLListaProductosBean;
import dacstpi.dao.DaoException;
import dacstpi.dao.TarjetaDao;
import dacstpi.model.Producto;
import dacstpi.model.Tarjeta;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("productos")
public class ProductosResources {

    @Inject
    private MLListaProductosBean productosBean;


    @GET
    @Produces ("application/json; charset=UTF-8")
    public List<Producto> getProductos(@QueryParam("query") String query) {
        productosBean.setQuery(query);
        try {
            productosBean.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (productosBean.getListaProducto().isEmpty()) {
            return null;
        }else{
            return productosBean.getListaProducto();
        }
    }
}
