package br.com.zup.nossocartao.transacao.transacaodocartao.response;

public class TransacaoEstabelecimentoResponse {

    private String nome;
    private String cidade;
    private String endereco;

    public TransacaoEstabelecimentoResponse(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
