package ma.emsi.zouitina.tp3restzouitina;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiqueResource {

    /**
     * Renvoie la ville ou le pays demandé dans un tableau JSON.
     *
     * @param lieu le nom reçu dans l’URL
     * @return un tableau contenant le nom du lieu
     */
    @GET
    @Path("/lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] endroitsDeVisite(@PathParam("ville_ou_pays") String lieu) {
        return new String[] { lieu };
    }
}