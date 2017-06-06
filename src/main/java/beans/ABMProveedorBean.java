package beans;


import dao.DaoException;
import dao.ProveedorDao;
import model.Proveedor;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "abmproveedorbean")
@SessionScoped
public class ABMProveedorBean {
    private Proveedor proveedor;
    @EJB
    private ProveedorDao proveedorDao;
    private List<Proveedor> proveedorList;

    @PostConstruct
    public void init(){
        try {
            this.proveedor = new Proveedor();
            proveedorList = proveedorDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public List<Proveedor> getProveedores(){
        return proveedorList;
    }

    public String updateProveedor(){
        try {
            proveedorDao.merge(this.proveedor);
            proveedorList = proveedorDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMProveedor.xhtml?faces-redirect=true";
    }

    public String agregarProveedor(){
        try {
            proveedorDao.persist(this.proveedor);
            proveedorList = proveedorDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMProveedor.xhtml?faces-redirect=true";
    }

    public String crearProveedor(){
        this.proveedor = new Proveedor();
        return "createProveedor.xhtml?faces-redirect=true";
    }

    public String removeProveedor(Proveedor p){
        try {
            proveedorDao.remove(p);
            proveedorList = proveedorDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "ABMProveedor.xhtml?faces-redirect=true";
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String editProveedor (Proveedor p){
        try {
            proveedor = proveedorDao.findById(p.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "editProveedor.xhtml?faces-redirect=true";
    }
}
