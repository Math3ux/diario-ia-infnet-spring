package br.com.diario.diario_ia.strategy;

import br.com.diario.diario_ia.domain.EntradaDiario;
import br.com.diario.diario_ia.port.ModeloLinguagem;
import org.springframework.stereotype.Component;

@Component("sentimento")
public class ReflexaoSentimento implements EstrategiaReflexao {
    @Override
    public String gerarReflexao(EntradaDiario entrada, ModeloLinguagem modelo) {
        String prompt = "Responda de forma curta. Qual o sentimento predominante neste texto: " + entrada.getConteudo();
        return modelo.processarPrompt(prompt);
    }
}
