package dacstpi.ws;

import dacstpi.dao.DaoException;
import dacstpi.dao.TarjetaDao;
import dacstpi.model.Tarjeta;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("tarjeta")
public class TarjetaResources {

    @EJB
    private TarjetaDao dao;
    private List<Tarjeta> listTarjeta;

    @GET
    @Produces ("application/json; charset=UTF-8")
    public List<Tarjeta> tarjetas() {
        try {
            listTarjeta =  dao.findAll();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }
}
