package ma.emsi.zouitina.tp3restzouitina;

import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.zouitina.tp3restzouitina.llm.LlmClientForGuideTouristique;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClientForGuideTouristique client;

    /**
     * Renvoie les lieux à visiter et le prix moyen estimé d'un repas.
     *
     * @param lieu la ville ou le pays demandé dans l'URL
     * @param nb le nombre de lieux à proposer, deux par défaut
     * @return les informations touristiques au format JSON
     */
    @GET
    @Path("/lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(
            @PathParam("ville_ou_pays") String lieu,
            @QueryParam("nb") @DefaultValue("2") int nb) {

        if (nb < 1) {
            throw new BadRequestException("nb doit être supérieur ou égal à 1.");
        }

        return client.conseiller(lieu, nb);
    }
}