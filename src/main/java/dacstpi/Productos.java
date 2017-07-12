package dacstpi;

import dacstpi.model.Producto;

import java.util.List;

/**
 * Created by pablo on 11/07/2017.
 */
public class Productos {
    private List<Producto> productos;

    public Productos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
