package br.com.diario.diario_ia.adapter;

import br.com.diario.diario_ia.port.ModeloLinguagem;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class OpenaiAdapter implements ModeloLinguagem {

    @Value("${openai.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public OpenaiAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String processarPrompt(String prompt) {

        return "Resposta simulada da OpenAI para o prompt: " + prompt;
    }

}
