package br.com.diario.diario_ia.strategy;

import br.com.diario.diario_ia.domain.EntradaDiario;
import br.com.diario.diario_ia.port.ModeloLinguagem;

public interface EstrategiaReflexao {
    String gerarReflexao(EntradaDiario entrada, ModeloLinguagem modelo);
}
