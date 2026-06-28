package br.com.diario.diario_ia;

import br.com.diario.diario_ia.domain.EntradaDiario;
import br.com.diario.diario_ia.service.AssistenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiarioIaApplication implements CommandLineRunner {

	private final AssistenteService assistenteService;

	public DiarioIaApplication(AssistenteService assistenteService) {
		this.assistenteService = assistenteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DiarioIaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n=============================================");
		System.out.println("Iniciando Diário de IA (Spring Boot + Gemini)");
		System.out.println("=============================================\n");

		EntradaDiario entrada = new EntradaDiario(
				"001",
				"Hoje o dia foi produtivo. Consegui finalizar a estruturação de um projeto da faculdade aplicando Clean Code e padrões de projeto. Me sinto confiante, mas o prazo de entrega me deixa um pouco ansioso.",
				"27/06/2026"
		);

		System.out.println("NOTA DO DIÁRIO: " + entrada.getConteudo());

		System.out.println("\n>> Solicitando Análise de Sentimento ao Gemini...");
		assistenteService.executarReflexao(entrada, "sentimento");

		System.out.println("\n>> Solicitando Perguntas de Autoconhecimento ao Gemini...");
		assistenteService.executarReflexao(entrada, "autoconhecimento");

		System.out.println("\n=============================================");
	}
}
