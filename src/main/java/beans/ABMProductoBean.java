package beans;


import dao.DaoException;
import dao.ProductoDao;
import model.Producto;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "abmproductobean")
@SessionScoped
public class ABMProductoBean {
    private Producto producto;
    @EJB
    private ProductoDao productoDao;
    private List<Producto> productoList;

    @PostConstruct
    public void init(){
        try {
            this.producto = new Producto();
            productoList = productoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> getProductos(){
        return productoList;
    }

    public String updateProducto(){
        try {
            productoDao.merge(this.producto);
            productoList = productoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "/ABMProducto/ABMProducto.xhtml?faces-redirect=true";
    }

    public String agregarProducto(){
        try {
            productoDao.persist(this.producto);
            productoList = productoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "/ABMProducto/ABMProducto.xhtml?faces-redirect=true";
    }

    public String crearProducto(){
        this.producto = new Producto();
        return "/ABMProducto/createProducto.xhtml?faces-redirect=true";
    }

    public String removeProducto(Producto p){
        try {
            productoDao.remove(p);
            productoList = productoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "/ABMProducto/ABMProducto.xhtml?faces-redirect=true";
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String editProducto(Producto p){
        try {
            producto = productoDao.findById(p.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "/ABMProducto/editProducto.xhtml?faces-redirect=true";
    }

}
