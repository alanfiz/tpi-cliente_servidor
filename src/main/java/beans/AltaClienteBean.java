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
    public void init(){this.cliente = new Cliente("usuario", "pass", "nom", "ape", 00000000, "email@email.com", "calle", 000, "infoadicional", "pais", "provincia", "ciudad", 0000, 00000000);}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarCliente(){
        try {
            clientedao.merge(this.cliente);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}
