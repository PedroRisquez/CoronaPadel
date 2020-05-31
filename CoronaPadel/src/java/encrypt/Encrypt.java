/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encrypt;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        Encrypt client = new Encrypt();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author pedro
 */
public class Encrypt {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/EncriptaClaveWS/webresources";

    public Encrypt() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public String cifraPass(String clave) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (clave != null) {
            resource = resource.queryParam("clave", clave);
        }
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public String descifraHTML(String claveCifrada) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (claveCifrada != null) {
            resource = resource.queryParam("claveCifrada", claveCifrada);
        }
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public void close() {
        client.close();
    }
    
}
