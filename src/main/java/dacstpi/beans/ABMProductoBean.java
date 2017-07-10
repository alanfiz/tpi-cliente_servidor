package dacstpi.beans;


import dacstpi.dao.DaoException;
import dacstpi.dao.ProdComDao;
import dacstpi.dao.ProductoDao;
import dacstpi.model.Comision;
import dacstpi.model.ProdCom;
import dacstpi.model.Producto;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "abmproductobean")
@ViewScoped
public class ABMProductoBean {
    private Producto producto;
    private ProdCom prodCom;

    @EJB
    private ProductoDao productoDao;
    @EJB
    private ProdComDao prodComDao;

    private List<Producto> productoList;
    private Long id;

    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(!context.isPostback()) {
            try {
                if(id == null) {
                    this.producto = new Producto();
                    this.prodCom = new ProdCom();
                    productoList = productoDao.findAll();
                }else {
                    this.producto = productoDao.findById(id);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
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
        return "ABMProducto.xhtml?faces-redirect=true";
    }

    public String agregarProducto(){
        try {
            productoDao.persist(this.producto);
            productoList = productoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMProducto.xhtml?faces-redirect=true";
    }

    public String crearProducto(){
        this.producto = new Producto();
        return "createProducto.xhtml?faces-redirect=true";
    }

    public String removeProducto(Producto p){
        try {
            productoDao.remove(p);
            productoList = productoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "ABMProducto.xhtml?faces-redirect=true";
    }

    public String agregarComision(Comision comision){
        try {
            prodCom.setProducto(this.producto);
            prodCom.setComision(comision);
            prodComDao.persist(this.prodCom);
            producto.getComision().add(prodCom);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMProducto.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "editProducto.xhtml?faces-redirect=true";
    }

}
