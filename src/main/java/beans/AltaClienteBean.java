package beans;

import dao.ClienteDao;
import dao.DaoException;
import model.Cliente;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "AltaClienteBean")
@RequestScoped
public class AltaClienteBean {

    @EJB
    private ClienteDao clientedao;

    private Cliente cliente;

    @PostConstruct
    public void init(){cliente = new Cliente();}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarCliente(){
        try {
            clientedao.persist(this.cliente);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}
