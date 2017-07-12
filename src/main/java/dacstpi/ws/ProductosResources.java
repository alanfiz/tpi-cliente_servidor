package dacstpi.ws;

import dacstpi.Productos;
import dacstpi.beans.MLListaProductosBean;
import dacstpi.model.Producto;

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

    private Productos productos;

    @GET
    @Produces ("application/json; charset=UTF-8")
    public Productos getProductos(@QueryParam("query") String query) {
        productosBean.setQuery(query);
        try {
            productosBean.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (productosBean.getListaProducto().isEmpty()) {
            return null;
        }else{
            return productos = new Productos(productosBean.getListaProducto());
        }
    }
}
