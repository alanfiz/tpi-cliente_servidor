package dacstpi.beans;


import dacstpi.dao.ComisionDao;
import dacstpi.dao.DaoException;
import dacstpi.model.Comision;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "abmcomisionbean")
@ViewScoped
public class ABMComisionBean {
    private Long id;
    private Comision comision;
    @EJB
    private ComisionDao comisionDao;
    private List<Comision> comisionList;

    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(!context.isPostback()) {
            try {
                if(id == null) {
                    this.comision = new Comision();
                    comisionList = comisionDao.findAll();
                }else {
                    this.comision = comisionDao.findById(id);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Comision> getComisiones(){
        return comisionList;
    }

    public String updateComision(){
        try {
            comisionDao.merge(this.comision);
            comisionList = comisionDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMComision.xhtml?faces-redirect=true";
    }

    public String agregarComision(){
        try {
            comisionDao.persist(this.comision);
            comisionList = comisionDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMComision.xhtml?faces-redirect=true";
    }

    public String crearComision(){
        this.comision = new Comision();
        return "createComision.xhtml?faces-redirect=true";
    }

    public String removeComision(Comision c){
        try {
            comisionDao.remove(c);
            comisionList = comisionDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "ABMComision.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comision getComision() {
        return comision;
    }

    public void setComision(Comision comision) {
        this.comision = comision;
    }

    public String editComision(Comision c){
        try {
            comision = comisionDao.findById(c.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "editComision.xhtml?faces-redirect=true";
    }

}