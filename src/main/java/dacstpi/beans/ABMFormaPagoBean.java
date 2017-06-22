package dacstpi.beans;

import dacstpi.dao.DaoException;
import dacstpi.dao.FormaPagoDao;
import dacstpi.model.FormaPago;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name = "abmformapagobean")
@ViewScoped
public class ABMFormaPagoBean {
    private FormaPago formaPago;
    @EJB
    private FormaPagoDao formaPagoDao;
    private List<FormaPago> formaPagoList;
    private Long id;

    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(!context.isPostback()) {
            try {
                if(id == null) {
                    this.formaPago = new FormaPago();
                    formaPagoList = formaPagoDao.findAll();
                }else {
                    this.formaPago = formaPagoDao.findById(id);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }

    public List<FormaPago> getFormaPagos(){
        return formaPagoList;
    }

    public String updateFormaPago(){
        try {
            formaPagoDao.merge(this.formaPago);
            formaPagoList = formaPagoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMFormaPago.xhtml?faces-redirect=true";
    }

    public String agregarFormaPago(){
        try {
            formaPagoDao.persist(this.formaPago);
            formaPagoList = formaPagoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMFormaPago.xhtml?faces-redirect=true";
    }

    public String crearFormaPago(){
        this.formaPago = new FormaPago();
        return "createFormaPago.xhtml?faces-redirect=true";
    }

    public String removeFormaPago(FormaPago f){
        try {
            formaPagoDao.remove(f);
            formaPagoList = formaPagoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "ABMFormaPago.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public String editFormaPago (FormaPago f){
        try {
            formaPago = formaPagoDao.findById(f.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "editFormaPago.xhtml?faces-redirect=true";
    }

}
