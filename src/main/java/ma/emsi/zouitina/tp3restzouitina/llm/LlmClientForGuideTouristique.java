package ma.emsi.zouitina.tp3restzouitina.llm;

import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.Duration;

@ApplicationScoped
public class LlmClientForGuideTouristique {

    private GuideTouristique guide;

    @PostConstruct
    void initialiser() {
        String cle = System.getenv("GEMINI_KEY");
        if (cle == null || cle.isBlank()) {
            throw new IllegalStateException("La variable GEMINI_KEY est absente.");
        }

        var modele = GoogleGenAiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-3.5-flash-lite")
                .responseFormat(ResponseFormat.JSON)
                .timeout(Duration.ofSeconds(90))
                .build();

        guide = AiServices.builder(GuideTouristique.class)
                .chatModel(modele)
                .build();
    }

    public String conseiller(String lieu, int nombreDeLieux) {
        return guide.conseiller(
                "Lieu demandé : %s%nNombre de lieux à visiter : %d"
                        .formatted(lieu, nombreDeLieux));
    }
}