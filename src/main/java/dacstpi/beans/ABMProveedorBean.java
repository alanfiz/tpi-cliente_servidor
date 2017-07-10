package dacstpi.beans;


import dacstpi.dao.DaoException;
import dacstpi.dao.ProvComDao;
import dacstpi.dao.ProveedorDao;
import dacstpi.model.Comision;
import dacstpi.model.ProvCom;
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
    private ProvCom provCom;
    @EJB
    private ProveedorDao proveedorDao;
    @EJB
    private ProvComDao provComDao;
    private List<Proveedor> proveedorList;
    private Long id;

    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(!context.isPostback()) {
            try {
                if(id == null) {
                    this.proveedor = new Proveedor();
                    this.provCom = new ProvCom();
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

    public String agregarComision(Comision comision){
        try {
            provCom.setProveedor(this.proveedor);
            provCom.setComision(comision);
            provComDao.persist(this.provCom);
            proveedor.getComision().add(provCom);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMProveedor.xhtml?faces-redirect=true";
    }

    public ProvCom getProvCom() {
        return provCom;
    }

    public void setProvCom(ProvCom provCom) {
        this.provCom = provCom;
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
