package beans;

import dao.DaoException;
import dao.VentaDao;
import model.Venta;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "abmventabean")
@ViewScoped
public class ABMVentaBean {
    private Venta venta;
    @EJB
    private VentaDao ventaDao;
    private List<Venta> ventaList;

    @PostConstruct
    public void init(){
        try {
            this.venta = new Venta();
            ventaList = ventaDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
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
