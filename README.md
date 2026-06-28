# Diário IA

Diário IA é uma aplicação Java Spring Boot que demonstra uma integração simples com um modelo de linguagem (adaptador para Gemini) para analisar entradas de diário. A aplicação exemplifica uma arquitetura hexagonal/simples com:
- `ModeloLinguagem` (porta) — interface que define a comunicação com o LLM
- `GeminiAdapter` (adapter) — implementação que faz chamadas HTTP à API do Gemini
- `AssistenteService` — orquestra estratégias de reflexão sobre uma `EntradaDiario`
- `EstrategiaReflexao` (estratégias) — classes que geram prompts específicos (sentimento, autoconhecimento, etc.)

### Tecnologias
- Java 17+ (verifique seu JDK)
- Spring Boot
- Maven

### Configuração
A aplicação lê a chave da API do Gemini a partir de `src/main/resources/application.properties` com a propriedade `gemini.api.key`:

```properties
spring.application.name=diario-ia
# Substitua pela sua key localmente.
gemini.api.key=SEU_GEMINI_API_KEY_AQUI
```

### Build e execução

Para construir o projeto:

```powershell
mvn clean package
```

Executar em desenvolvimento (Spring Boot):

```powershell
mvn spring-boot:run
```

Ou executar o JAR gerado:

```powershell
java -jar target/diario-ia-0.0.1-SNAPSHOT.jar
```

Executar testes:

```powershell
mvn test
```

### Comportamento da aplicação

A aplicação principal `DiarioIaApplication` implementa `CommandLineRunner` e, ao iniciar, cria uma `EntradaDiario` de exemplo e solicita duas reflexões ao assistente: `sentimento` e `autoconhecimento`. As respostas vindas do Gemini são exibidas no console.

### Estrutura do projeto (resumo)

- `src/main/java/br/com/diario/diario_ia/`
  - `DiarioIaApplication.java` — ponto de entrada (exemplo de uso)
  - `adapter/GeminiAdapter.java` — implementação de `ModeloLinguagem` que chama a API do Gemini
  - `config/AppConfig.java` — beans de configuração (ex.: RestTemplate)
  - `domain/EntradaDiario.java` — modelo de dados simples
  - `port/ModeloLinguagem.java` — porta (interface) para LLMs
  - `service/AssistenteService.java` — orquestrador das estratégias
  - `strategy/` — várias estratégias de reflexão (ex.: `ReflexaoSentimento`, `ReflexaoAutoconhecimento`)

### Exemplo de saída (console)

Ao rodar, você verá algo semelhante a:

```
Iniciando Diário de IA (Spring Boot + Gemini)
NOTA DO DIÁRIO: Hoje o dia foi produtivo... (conteúdo)
>> Solicitando Análise de Sentimento ao Gemini...
[resposta do Gemini exibida aqui]
>> Solicitando Perguntas de Autoconhecimento ao Gemini...
[resposta do Gemini exibida aqui]
```
