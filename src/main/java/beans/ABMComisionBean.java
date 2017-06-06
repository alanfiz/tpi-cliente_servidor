package beans;


import dao.ComisionDao;
import dao.DaoException;
import model.Comision;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "abmcomisionbean")
@SessionScoped
public class ABMComisionBean {
    private Comision comision;
    @EJB
    private ComisionDao comisionDao;
    private List<Comision> comisionList;

    @PostConstruct
    public void init(){
        try {
            this.comision = new Comision();
            comisionList = comisionDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
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
        return "/ABMComision/ABMComision.xhtml?faces-redirect=true";
    }

    public String agregarComision(){
        try {
            comisionDao.persist(this.comision);
            comisionList = comisionDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "/ABMComision/ABMComision.xhtml?faces-redirect=true";
    }

    public String crearComision(){
        this.comision = new Comision();
        return "/ABMComision/createComision.xhtml?faces-redirect=true";
    }

    public String removeComision(Comision c){
        try {
            comisionDao.remove(c);
            comisionList = comisionDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "/ABMComision/ABMComision.xhtml?faces-redirect=true";
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
        return "/ABMComision/editComision.xhtml?faces-redirect=true";
    }

}