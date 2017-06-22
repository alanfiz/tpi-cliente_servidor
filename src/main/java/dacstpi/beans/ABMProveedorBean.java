package dacstpi.beans;


import dacstpi.dao.DaoException;
import dacstpi.dao.ProveedorDao;
import dacstpi.model.Proveedor;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "abmproveedorbean")
@ViewScoped
public class ABMProveedorBean {
    private Proveedor proveedor;
    @EJB
    private ProveedorDao proveedorDao;
    private List<Proveedor> proveedorList;
    private Long id;

    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(!context.isPostback()) {
            try {
                if(id == null) {
                    this.proveedor = new Proveedor();
                    proveedorList = proveedorDao.findAll();
                }else {
                    this.proveedor = proveedorDao.findById(id);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
