package beans;

import dao.DaoException;
import dao.FormapagoDao;
import model.FormaPago;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.text.Normalizer;
import java.util.List;

@ManagedBean(name = "abmformapagobean")
@SessionScoped
public class ABMFormaPagoBean {
    private FormaPago formaPago;
    @EJB
    private FormapagoDao formapagoDao;
    private List<FormaPago> formaPagoList;

    @PostConstruct
    public void init(){
        try {
            this.formaPago = new FormaPago();
            formaPagoList = formapagoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public List<FormaPago> getFormaPagos(){
        return formaPagoList;
    }

    public String updateFormaPago(){
        try {
            formapagoDao.merge(this.formaPago);
            formaPagoList = formapagoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "/ABMFormaPago/ABMFormaPago.xhtml?faces-redirect=true";
    }

    public String agregarFormaPago(){
        try {
            formapagoDao.persist(this.formaPago);
            formaPagoList = formapagoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "/ABMFormaPago/ABMFormaPago.xhtml?faces-redirect=true";
    }

    public String crearFormaPago(){
        this.formaPago = new FormaPago();
        return "/ABMCliente/createCliente.xhtml?faces-redirect=true";
    }

    public String removeFormaPago(FormaPago f){
        try {
            formapagoDao.remove(f);
            formaPagoList = formapagoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "/ABMFormaPago/ABMFormaPago.xhtml?faces-redirect=true";
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public String editFormaPago (FormaPago f){
        try {
            formaPago = formapagoDao.findById(f.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "/ABMFormaPago/editFormaPago.xhtml?faces-redirect=true";
    }

}
