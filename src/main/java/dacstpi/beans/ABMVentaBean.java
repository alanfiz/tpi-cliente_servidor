package dacstpi.beans;

import dacstpi.dao.DaoException;
import dacstpi.dao.VentaDao;
import dacstpi.model.Venta;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "abmventabean")
@ViewScoped
public class ABMVentaBean {
    private Venta venta;
    @EJB
    private VentaDao ventaDao;
    private List<Venta> ventaList;
    private Long id;

    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(!context.isPostback()) {
            try {
                if(id == null) {
                    this.venta = new Venta();
                    ventaList = ventaDao.findAll();
                }else {
                    this.venta = ventaDao.findById(id);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Venta> getVentas(){
        return ventaList;
    }

    public String updateVenta(){
        try {
            ventaDao.merge(this.venta);
            ventaList = ventaDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMVenta.xhtml?faces-redirect=true";
    }

    public String agregarVenta(){
        try {
            ventaDao.persist(this.venta);
            ventaList = ventaDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMVenta.xhtml?faces-redirect=true";
    }

    public String crearVenta(){
        this.venta = new Venta();
        return "createVenta.xhtml?faces-redirect=true";
    }

    public String removeVenta(Venta v){
        try {
            ventaDao.remove(v);
            ventaList = ventaDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "ABMVenta.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String editVenta(Venta v){
        try {
            venta = ventaDao.findById(v.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "editVenta.xhtml?faces-redirect=true";
    }

}
