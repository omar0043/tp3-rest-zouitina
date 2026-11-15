package ma.emsi.zouitina.tp3restzouitina;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.zouitina.tp3restzouitina.llm.LlmClientForGuideTouristique;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClientForGuideTouristique client;

    /**
     * Renvoie deux lieux à visiter et le prix moyen estimé d'un repas.
     *
     * @param lieu la ville ou le pays demandé dans l'URL
     * @return les informations touristiques au format JSON
     */
    @GET
    @Path("/lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(@PathParam("ville_ou_pays") String lieu) {
        return client.conseiller(lieu);
    }
}