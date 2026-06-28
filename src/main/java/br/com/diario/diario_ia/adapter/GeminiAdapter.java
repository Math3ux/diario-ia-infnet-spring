package br.com.diario.diario_ia.adapter;

import br.com.diario.diario_ia.port.ModeloLinguagem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiAdapter implements ModeloLinguagem {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GeminiAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String processarPrompt(String prompt) {
        String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" + apiKey;
        HttpEntity<String> requisicao = montarRequisicao(prompt);

        try {
            String respostaJson = restTemplate.postForObject(url, requisicao, String.class);
            return extrairTextoDaResposta(respostaJson);
        } catch (Exception e) {
            return "Erro ao se comunicar com a API: " + e.getMessage();
        }
    }

    private HttpEntity<String> montarRequisicao(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String corpo = String.format("{\"contents\": [{\"parts\": [{\"text\": \"%s\"}]}]}", prompt.replace("\"", "\\\""));
        return new HttpEntity<>(corpo, headers);
    }

    private String extrairTextoDaResposta(String json) {
        if (json == null || !json.contains("\"text\":")) return "Sem resposta válida.";
        String[] partes = json.split("\"text\": \"");
        return partes.length > 1 ? partes[1].split("\"")[0].replace("\\n", "\n") : "Formato inesperado.";
    }
}
