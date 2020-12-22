package br.com.zup.nossocartao.transacao.transacaodocartao.response;


import br.com.zup.nossocartao.transacao.transacaodocartao.entity.TransacaoEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransacaoResponse {

    private UUID transacaoId;
    private BigDecimal valor;
    private TransacaoEstabelecimentoResponse estabelecimento;
    private LocalDateTime efetivadaEm;

    public TransacaoResponse(@JsonProperty("id") UUID transacaoId,
                             @JsonProperty("valor") BigDecimal valor,
                             @JsonProperty("estabelecimento") TransacaoEstabelecimentoResponse estabelecimento,
                             @JsonProperty("efetivadaEm") LocalDateTime efetivadaEm) {
        this.transacaoId = transacaoId;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.efetivadaEm = efetivadaEm;
    }

    public UUID getTransacaoId() {
        return transacaoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public TransacaoEstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public static TransacaoResponse fromModel(TransacaoEntity transacao) {
        TransacaoEstabelecimentoResponse transacaoEstabelecimentoResponse = new TransacaoEstabelecimentoResponse(transacao.getEstabelecimento().getEstabelecimentoNome(),
                transacao.getEstabelecimento().getEstabelecimentoCidade(),
                transacao.getEstabelecimento().getEstabelecimentoEndereco());

        return new TransacaoResponse(transacao.getTransacaoId(),
                transacao.getValor(),
                transacaoEstabelecimentoResponse,
                transacao.getEfetivadaEm());
    }
}
