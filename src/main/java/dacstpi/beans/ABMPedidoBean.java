package dacstpi.beans;

import dacstpi.dao.ClienteDao;
import dacstpi.dao.DaoException;
import dacstpi.dao.PedidoDao;
import dacstpi.model.Cliente;
import dacstpi.model.Pedido;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "abmpedidobean")
@ViewScoped
public class ABMPedidoBean {
    private Pedido pedido;
    private Long id;
//    private Cliente cliente;
    @EJB
    private PedidoDao pedidoDao;
    @EJB
    private ClienteDao clienteDao;
    private List<Pedido> pedidoList;

    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        if(!context.isPostback()) {
            try {
                if(id == null) {
                    this.pedido = new Pedido();
                    pedidoList = pedidoDao.findAll();
                }else {
                    this.pedido = pedidoDao.findById(id);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Pedido> getPedidos(){
        return pedidoList;
    }

    public String updatePedido(){
        try {
            pedido.setFechayhoraPedido(new Date());
            pedidoDao.merge(this.pedido);
            pedidoList = pedidoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMPedido.xhtml?faces-redirect=true";
    }

    public String agregarPedido(){
        try {
//            Cliente c = clienteDao.findById(this.idCliente);
//            pedido.setCliente(cliente);
            pedido.setFechayhoraPedido(new Date());
            pedidoDao.persist(this.pedido);
            pedidoList = pedidoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "ABMPedido.xhtml?faces-redirect=true";
    }

    public String crearPedido(){
        this.pedido = new Pedido();
        return "createPedido.xhtml?faces-redirect=true";
    }

    public String removePedido(Pedido p){
        try {
            pedidoDao.remove(p);
            pedidoList = pedidoDao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return "ABMPedido.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }

    public String editPedido(Pedido p){
        try {
            pedido = pedidoDao.findById(p.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return "editPedido.xhtml?faces-redirect=true";
    }


}
