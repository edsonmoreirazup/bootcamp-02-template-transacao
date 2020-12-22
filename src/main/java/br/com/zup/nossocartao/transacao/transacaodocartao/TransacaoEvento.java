package br.com.zup.nossocartao.transacao.transacaodocartao;

import br.com.zup.nossocartao.transacao.transacaodocartao.entity.CartaoEntity;
import br.com.zup.nossocartao.transacao.transacaodocartao.entity.TransacaoEntity;
import br.com.zup.nossocartao.transacao.transacaodocartao.request.TransacaoCartaoRequest;
import br.com.zup.nossocartao.transacao.transacaodocartao.request.TransacaoEstabelecimentoRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoEvento {


    private @NotNull UUID transacaoid;
    private @Positive BigDecimal valor;
    private @NotNull @Valid TransacaoEstabelecimentoRequest estabelecimento;
    private @NotNull @Valid TransacaoCartaoRequest cartao;
    private @FutureOrPresent LocalDateTime efetivadaEm;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TransacaoEvento(@JsonProperty("id")@NotNull UUID transacaoid,
                           @JsonProperty("valor") @Positive BigDecimal valor,
                           @JsonProperty("estabelecimento") @NotNull @Valid TransacaoEstabelecimentoRequest estabelecimento,
                           @JsonProperty("cartao") @NotNull @Valid TransacaoCartaoRequest cartao,
                           @JsonProperty("efetivadaEm") @FutureOrPresent LocalDateTime efetivadaEm) {

        this.transacaoid = transacaoid;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public UUID getTransacaoid() {
        return transacaoid;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TransacaoEstabelecimentoRequest getEstabelecimento() {
        return estabelecimento;
    }

    public TransacaoCartaoRequest getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public TransacaoEntity toModel(CartaoEntity cartao){
        return new TransacaoEntity(this.valor, this.efetivadaEm, this.estabelecimento.toModel(), cartao);
    }


    @Override
    public String toString() {
        return "TransacaoEvento{" +
                "transacaoid=" + transacaoid +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}
