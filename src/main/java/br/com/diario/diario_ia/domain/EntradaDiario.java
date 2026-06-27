package br.com.diario.diario_ia.domain;

public class EntradaDiario {
    private String id;
    private String conteudo;
    private String dataCriacao;

    public EntradaDiario(String id, String conteudo, String dataCriacao) {
        this.id = id;
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getId() {
        return id;
    }
}
