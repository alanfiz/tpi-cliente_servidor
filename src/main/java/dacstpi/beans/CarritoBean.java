package dacstpi.beans;

import dacstpi.dao.DaoException;
import dacstpi.dao.PedProdDao;
import dacstpi.dao.PedidoDao;
import dacstpi.model.PedProd;
import dacstpi.model.Pedido;
import dacstpi.model.Producto;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "abmpedidobean")
@ViewScoped
public class CarritoBean {
    private Pedido pedido;
    private PedProd pedProd;

    private Long id;
    //    private Cliente cliente;
    @EJB
    private PedidoDao pedidoDao;
    @EJB
    private PedProdDao pedProdDao;

    @Inject
    private LoginBean loginBean;
    private List<Pedido> pedidoList;

    @PostConstruct
    public void init(){
        pedido = new Pedido();
        pedidoList = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
        pedProd.setPedido(pedido);
        pedProd.setProducto(producto);
        try {
            pedProdDao.persist(pedProd);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void quitarProducto(Producto producto){
        pedProd.setPedido(pedido);
        pedProd.setProducto(producto);
        try {
            pedProdDao.persist(pedProd);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public PedProd getPedProd() {
        return pedProd;
    }

    public void setPedProd(PedProd pedProd) {
        this.pedProd = pedProd;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


}
