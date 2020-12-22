package br.com.zup.nossocartao.transacao.transacaodocartao.request;

import br.com.zup.nossocartao.transacao.transacaodocartao.entity.CartaoEntity;
import br.com.zup.nossocartao.transacao.transacaodocartao.entity.EstabelecimentoEntity;
import br.com.zup.nossocartao.transacao.transacaodocartao.entity.TransacaoEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class TransacaoEstabelecimentoRequest {

    @NotBlank
    private String estabelecimentoNome;

    @NotBlank
    private String estabelecimentoCidade;

    @NotBlank
    private String estabelecimentoEndereco;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TransacaoEstabelecimentoRequest(@JsonProperty(value = "nome") @NotBlank String estabelecimentoNome, @JsonProperty(value = "cidade") @NotBlank String estabelecimentoCidade,
                                           @JsonProperty(value = "endereco") @NotBlank String estabelecimentoEndereco) {
        this.estabelecimentoNome = estabelecimentoNome;
        this.estabelecimentoCidade = estabelecimentoCidade;
        this.estabelecimentoEndereco = estabelecimentoEndereco;
    }

    public String getEstabelecimentoNome() {
        return estabelecimentoNome;
    }

    public String getEstabelecimentoCidade() {
        return estabelecimentoCidade;
    }

    public String getEstabelecimentoEndereco() {
        return estabelecimentoEndereco;
    }

    public EstabelecimentoEntity toModel(){
        return new EstabelecimentoEntity(this.estabelecimentoNome, this.estabelecimentoCidade, this.estabelecimentoEndereco);
    }

    @Override
    public String toString() {
        return "TransacaoEstabelecimentoRequest{" +
                "estabelecimentoNome='" + estabelecimentoNome + '\'' +
                ", estabelecimentoCidade='" + estabelecimentoCidade + '\'' +
                ", estabelecimentoEndereco='" + estabelecimentoEndereco + '\'' +
                '}';
    }
}
