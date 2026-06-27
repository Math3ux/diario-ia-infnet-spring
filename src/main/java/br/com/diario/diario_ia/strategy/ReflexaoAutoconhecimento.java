package br.com.diario.diario_ia.strategy;

import br.com.diario.diario_ia.domain.EntradaDiario;
import br.com.diario.diario_ia.port.ModeloLinguagem;
import org.springframework.stereotype.Component;

@Component("autoconhecimento")
public class ReflexaoAutoconhecimento implements EstrategiaReflexao {
    @Override
    public String gerarReflexao(EntradaDiario entrada, ModeloLinguagem modelo) {
        String prompt = "Baseado neste texto de diário, gere 2 perguntas provocativas de autoconhecimento para o autor refletir: " + entrada.getConteudo();
        return modelo.processarPrompt(prompt);
    }
}
