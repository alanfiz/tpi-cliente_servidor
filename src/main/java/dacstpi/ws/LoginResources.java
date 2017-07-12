package dacstpi.ws;


import dacstpi.dao.ClienteDao;
import dacstpi.dao.DaoException;
import dacstpi.dao.UserRolDao;
import dacstpi.model.Cliente;
import dacstpi.model.UserRol;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;


@Path("login/")
public class LoginResources {

    private String rol;
    private String username;

    @EJB
    private ClienteDao clienteDao;
    private Cliente cliente;

    @EJB
    private UserRolDao userRolDao;
    private List<UserRol> listaUser;
    private UserRol userRol;


    @GET
    @Produces ("application/json; charset=UTF-8")
    public Cliente devolverCliente (@QueryParam("user") String user,@QueryParam("pass") String pass ) {
//        String user = "alanfiz92";
//        String pass = "34gw4ef34";

        try {
            listaUser = userRolDao.findAll();
            for (int i=0; i < listaUser.size(); i++){
                userRol = listaUser.get(i);
                if (userRol.getUsername().equals(user) && userRol.getRol().equals("cliente")){
                    cliente = userRol.getCliente();
                    break;
                }
            }

            if (cliente.getPasswordCliente().equals(pass)) {
                System.out.println(cliente.getPedidos());
            } else {cliente = null;}

        } catch (DaoException e) {
            e.printStackTrace();
        }
        if (cliente == null) {return null;} else {return cliente;}
    }


}