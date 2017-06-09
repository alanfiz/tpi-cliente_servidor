package dacstpi.beans;

import dacstpi.dao.ComisionPorcentualDao;
import dacstpi.dao.DaoException;
import dacstpi.model.ComisionPorcentual;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "abmcomisionporcentualbean")
@ViewScoped
public class ABMComisionPorcentualBean {
    private ComisionPorcentual comisionPorcentual;
    @EJB
    private ComisionPorcentualDao comisionPorcentualDao;
    private List<ComisionPorcentual> comisionPorcentualList;

    @PostConstruct
    public void init(){
        try {
            this.comisionPorcentual = new ComisionPorcentual();
            comisionPorcentualList = comisionPorcentualDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public List<ComisionPorcentual> getComisionPorcentuales(){
        return comisionPorcentualList;
    }

    public String updateComisionPorcentual(){
        try {
            comisionPorcentualDao.merge(this.comisionPorcentual);
            comisionPorcentualList = comisionPorcentualDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMComisionPorcentual.xhtml?faces-redirect=true";
    }

    public String agregarComisionPorcentual(){
        try {
            comisionPorcentualDao.persist(this.comisionPorcentual);
            comisionPorcentualList = comisionPorcentualDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMComisionPorcentual.xhtml?faces-redirect=true";
    }

    public String crearComisionPorcentual(){
        this.comisionPorcentual = new ComisionPorcentual();
        return "createComisionPorcentual.xhtml?faces-redirect=true";
    }

    public String removeComisionPorcentual(ComisionPorcentual c){
        try {
            comisionPorcentualDao.remove(c);
            comisionPorcentualList = comisionPorcentualDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "ABMComisionPorcentual.xhtml?faces-redirect=true";
    }

    public ComisionPorcentual getComisionPorcentual() {
        return comisionPorcentual;
    }

    public void setComisionPorcentual(ComisionPorcentual comisionPorcentual) {
        this.comisionPorcentual = comisionPorcentual;
    }

    public String editComisionPorcentual(ComisionPorcentual c){
        try {
            comisionPorcentual = comisionPorcentualDao.findById(c.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "editComisionPorcentual.xhtml?faces-redirect=true";
    }

}
