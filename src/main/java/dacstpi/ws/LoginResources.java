package dacstpi.ws;


import dacstpi.dao.AdministradorDao;
import dacstpi.dao.ClienteDao;
import dacstpi.dao.DaoException;
import dacstpi.dao.UserRolDao;
import dacstpi.model.Administrador;
import dacstpi.model.Cliente;
import dacstpi.model.UserRol;

import javax.ejb.EJB;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.*;
import java.util.ArrayList;
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
//            if (cliente == null) {cliente=clienteDao.findById(0L);}
            if (cliente.getPasswordCliente().equals(pass)) {} else {cliente = null;}

        } catch (DaoException e) {
            e.printStackTrace();
        }
        if (cliente == null) { return null;} else {return cliente;}
    }





}