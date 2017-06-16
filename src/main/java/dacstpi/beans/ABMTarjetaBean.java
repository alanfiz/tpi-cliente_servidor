package dacstpi.beans;


import dacstpi.dao.DaoException;
import dacstpi.dao.TarjetaDao;
import dacstpi.model.Tarjeta;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "abmtarjetabean")
@ViewScoped
public class ABMTarjetaBean {
    private Long id;
    private Tarjeta tarjeta;
    @EJB
    private TarjetaDao tarjetaDao;
    private List<Tarjeta> tarjetaList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    @PostConstruct
    public void init(){

        FacesContext context = FacesContext.getCurrentInstance();
        if(!context.isPostback()) {
            try {
                if(id == null) {
                    this.tarjeta = new Tarjeta();
                    tarjetaList = tarjetaDao.findAll();
                }else {
                    this.tarjeta = tarjetaDao.findById(id);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }

    }

    public List<Tarjeta> getTarjetas(){
        return tarjetaList;
    }

    public String updateTarjeta(){
        try {
            tarjetaDao.merge(this.tarjeta);
            tarjetaList = tarjetaDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMTarjeta.xhtml?faces-redirect=true";
    }

    public String agregarTarjeta(){
        try {
            tarjetaDao.persist(this.tarjeta);
            tarjetaList = tarjetaDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMTarjeta.xhtml?faces-redirect=true";
    }

    public String crearTarjeta(){
        this.tarjeta = new Tarjeta();
        return "createTarjeta.xhtml?faces-redirect=true";
    }

    public String removeTarjeta(Tarjeta t){
        try {
            tarjetaDao.remove(t);
            tarjetaList = tarjetaDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "ABMTarjeta.xhtml?faces-redirect=true";
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String editTarjeta(Tarjeta t){
        try {
            tarjeta = tarjetaDao.findById(t.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "editTarjeta.xhtml?faces-redirect=true";
    }

}
