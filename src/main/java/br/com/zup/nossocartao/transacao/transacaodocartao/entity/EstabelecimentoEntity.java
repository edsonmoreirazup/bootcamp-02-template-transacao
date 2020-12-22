package br.com.zup.nossocartao.transacao.transacaodocartao.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class EstabelecimentoEntity {

    private @NotBlank String estabelecimentoNome;
    private @NotBlank String estabelecimentoCidade;
    private @NotBlank String estabelecimentoEndereco;
    @Deprecated
    public EstabelecimentoEntity(){}

    public EstabelecimentoEntity(@NotBlank String estabelecimentoNome, @NotBlank String estabelecimentoCidade,
                                 @NotBlank String estabelecimentoEndereco) {
        this.estabelecimentoNome = estabelecimentoNome;
        this.estabelecimentoCidade = estabelecimentoCidade;
        this.estabelecimentoEndereco = estabelecimentoEndereco;
    }

    public String getEstabelecimentoNome() {
        return estabelecimentoNome;
    }

    public void setEstabelecimentoNome(String estabelecimentoNome) {
        this.estabelecimentoNome = estabelecimentoNome;
    }

    public String getEstabelecimentoCidade() {
        return estabelecimentoCidade;
    }

    public void setEstabelecimentoCidade(String estabelecimentoCidade) {
        this.estabelecimentoCidade = estabelecimentoCidade;
    }

    public String getEstabelecimentoEndereco() {
        return estabelecimentoEndereco;
    }

    public void setEstabelecimentoEndereco(String estabelecimentoEndereco) {
        this.estabelecimentoEndereco = estabelecimentoEndereco;
    }

    @Override
    public String toString() {
        return "EstabelecimentoEntity{" +
                "estabelecimentoNome='" + estabelecimentoNome + '\'' +
                ", estabelecimentoCidade='" + estabelecimentoCidade + '\'' +
                ", estabelecimentoEndereco='" + estabelecimentoEndereco + '\'' +
                '}';
    }
}
