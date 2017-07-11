package dacstpi.beans;

import dacstpi.dao.DaoException;
import dacstpi.model.Producto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@ManagedBean(name = "mllistaproductosbean")
@ViewScoped
public class MLListaProductosBean {

    private ArrayList<Producto> listaProducto;
    private String query;

    // HTTP GET request
    public void sendGet() throws Exception {
        listaProducto = new ArrayList<>();

        String url = "https://api.mercadolibre.com/sites/MLA/search?q=" + query;

        URL obj = new URL(url.replaceAll(" ","%20"));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("Accept", "application/json");

        //Muestra el codigo de la respuesta.. 200 es ok.
//      int responseCode = con.getResponseCode();
//      System.out.println("\nSending 'GET' request to URL : " + url);
//      System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
//        System.out.println(response.toString());

        JSONParser parser = new JSONParser();
        Object par = parser.parse(response.toString());

        JSONObject objJsonObject = new JSONObject(par.toString());
        JSONArray results = objJsonObject.getJSONArray("results");
        for (int i = 0; i < results.length(); i++) {
            Producto producto = new Producto();
            JSONObject explrObject = results.getJSONObject(i);

            producto.setNombreProducto(explrObject.getString("title"));
            producto.setPrecioUnitarioProducto(explrObject.getDouble("price"));
            producto.setMonedaProducto(explrObject.getString("currency_id"));

            JSONArray atributos = explrObject.getJSONArray("attributes");
            for (int j = 0; j < atributos.length(); j++) {
                JSONObject marca = atributos.getJSONObject(j);
                if (marca.getString("name").equals("Marca")) {
                    String marcaProducto = marca.getString("value_name");
                    if (!marcaProducto.isEmpty()) {
                        producto.setMarcaProducto(marcaProducto);
                    } else {
                        producto.setMarcaProducto("sin marca");
                    }
                    break;
                }
            }
            producto.setOrigenProducto("MercadoLibre");
            listaProducto.add(producto);
        }
    }

    public ArrayList<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(ArrayList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
