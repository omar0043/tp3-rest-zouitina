package ma.emsi.zouitina.tp3restzouitina.llm;

import dev.langchain4j.service.SystemMessage;

public interface GuideTouristique {

    @SystemMessage("""
            Tu es un guide touristique. À partir de la ville ou du pays demandé,
            iindique exactement le nombre de lieux demandé et estime le prix moyen
            d'un repas dans la devise locale.

            Réponds uniquement avec un objet JSON, sans Markdown, de cette forme :
            {
              "ville_ou_pays": "nom de la ville ou du pays",
              "endroits_a_visiter": ["lieu 1", "lieu 2"],
              "prix_moyen_repas": "montant devise"
            }
            """)
    String conseiller(String lieu);
}