package dacstpi.beans;

import dacstpi.dao.*;
import dacstpi.model.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "carritobean")
@ViewScoped
public class CarritoBean {

    private Producto producto;
    private Pedido pedido;
    private PedProd pedProd;
    private List<PedProd> pedProdList;
    private FormaPago formaPago;
    private List<Pedido> listaPedidos;
    private Double total;
    private List<Producto> listProductos;

    private Long id;
    //    private Cliente cliente;
    @EJB
    private PedidoDao pedidoDao;

    @EJB
    private PedProdDao pedProdDao;

    @EJB
    private ProductoDao productoDao;

    @EJB
    private ClienteDao clienteDao;

    @Inject
    private LoginBean loginBean;
    private Cliente cliente;


    @PostConstruct
    public void init() {
        pedProd = new PedProd();
        pedido = new Pedido();

    }


    public String agregarProducto(Producto producto) throws DaoException {

        productoDao.persist(producto);

//        pedProd.setPedido(pedido);
//        pedProdList = pedProdDao.findAll();
//
//        pedProd.setProducto(producto);
//
//        pedProdDao.persist(pedProd);
        total = total + producto.getPrecioUnitarioProducto();

        return "carro.xhtml";
    }

    public String quitarProducto(Producto p){
        try {
//        pedProdList = pedProdDao.findAll();
//        for(int i = 0; i<pedProdList.size();i++) {
//            if (pedProdList.get(i).getPedido().equals(pedido) && pedProdList.get(i).getProducto().equals(producto)){
//            pedProd.setId(pedProdList.get(i).getId());
            pedProd.setPedido(pedido);
            pedProd.setProducto(producto);
//            }
//        }
            pedProdDao.remove(pedProd);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "carro.xhtml";
    }

    public String vaciarCarro(){
        try {
            pedProdList = pedProdDao.findAll();
            for(int i = 0; i<pedProdList.size();i++) {
                pedProd.setId(pedProdList.get(i).getId());
                pedProdDao.remove(pedProd);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "carro.xhtml";
    }

    public void finalizarCompra(){
        if (!pedido.getProductos().isEmpty())
        pedido.setFormaPago(formaPago);
        pedido.setEstadoPedido("Realizado");
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

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public List<PedProd> getPedProdList() {
        return pedProdList;
    }

    public void setPedProdList(List<PedProd> pedProdList) {
        this.pedProdList = pedProdList;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
