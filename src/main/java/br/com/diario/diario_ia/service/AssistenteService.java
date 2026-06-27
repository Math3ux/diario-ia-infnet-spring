package br.com.diario.diario_ia.service;

import br.com.diario.diario_ia.domain.EntradaDiario;
import br.com.diario.diario_ia.port.ModeloLinguagem;
import br.com.diario.diario_ia.strategy.EstrategiaReflexao;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AssistenteService {

    private final ModeloLinguagem modeloLinguagem;
    private final Map<String, EstrategiaReflexao> estrategias;

    public AssistenteService(ModeloLinguagem modeloLinguagem, Map<String, EstrategiaReflexao> estrategias) {
        this.modeloLinguagem = modeloLinguagem;
        this.estrategias = estrategias;
    }

    public void executarReflexao(EntradaDiario entrada, String tipoReflexao) {
        EstrategiaReflexao estrategia = estrategias.get(tipoReflexao);

        if (estrategia == null) {
            System.out.println("Estratégia não suportada.");
            return;
        }

        String resultado = estrategia.gerarReflexao(entrada, this.modeloLinguagem);
        System.out.println(resultado);
    }
}
