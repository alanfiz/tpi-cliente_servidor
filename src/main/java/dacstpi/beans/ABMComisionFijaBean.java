package dacstpi.beans;

import dacstpi.dao.ComisionFijaDao;
import dacstpi.dao.DaoException;
import dacstpi.model.ComisionFija;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "abmcomisionfijabean")
@ViewScoped
public class ABMComisionFijaBean {
    private ComisionFija comisionFija;
    @EJB
    private ComisionFijaDao comisionFijaDao;
    private List<ComisionFija> comisionFijaList;

    @PostConstruct
    public void init(){
        try {
            this.comisionFija = new ComisionFija();
            comisionFijaList = comisionFijaDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public List<ComisionFija> getComisionFijas(){
        return comisionFijaList;
    }

    public String updateComisionFija(){
        try {
            comisionFijaDao.merge(this.comisionFija);
            comisionFijaList = comisionFijaDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMComisionFija.xhtml?faces-redirect=true";
    }

    public String agregarComisionFija(){
        try {
            comisionFijaDao.persist(this.comisionFija);
            comisionFijaList = comisionFijaDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMComisionFija.xhtml?faces-redirect=true";
    }

    public String crearComisionFija(){
        this.comisionFija = new ComisionFija();
        return "createComisionFija.xhtml?faces-redirect=true";
    }

    public String removeComisionFija(ComisionFija c){
        try {
            comisionFijaDao.remove(c);
            comisionFijaList = comisionFijaDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "ABMComisionFija.xhtml?faces-redirect=true";
    }

    public ComisionFija getComisionFija() {
        return comisionFija;
    }

    public void setComisionFija(ComisionFija comisionFija) {
        this.comisionFija = comisionFija;
    }

    public String editComisionFija(ComisionFija c){
        try {
            comisionFija= comisionFijaDao.findById(c.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "editComisionFija.xhtml?faces-redirect=true";
    }


}
