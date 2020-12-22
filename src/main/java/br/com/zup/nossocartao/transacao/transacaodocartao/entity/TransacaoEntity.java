package br.com.zup.nossocartao.transacao.transacaodocartao.entity;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "transacao")
public class TransacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "binary(16)")
    private UUID transacaoId;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    @FutureOrPresent
    private LocalDateTime efetivadaEm;

    @Embedded
    private EstabelecimentoEntity estabelecimento;

    @ManyToOne(optional = false)
    private CartaoEntity cartao;

    @Deprecated
    public TransacaoEntity() {
    }

    public TransacaoEntity(@NotNull @Positive BigDecimal valor, @NotNull @FutureOrPresent LocalDateTime efetivadaEm,
                           EstabelecimentoEntity estabelecimento, CartaoEntity cartao) {
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
    }

    public UUID getTransacaoId() {
        return transacaoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoEntity getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoEntity getCartao() {
        return cartao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransacaoEntity)) return false;
        TransacaoEntity that = (TransacaoEntity) o;
        return valor.equals(that.valor) && efetivadaEm.equals(that.efetivadaEm) && estabelecimento.equals(that.estabelecimento) && cartao.equals(that.cartao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, efetivadaEm, estabelecimento, cartao);
    }

    @Override
    public String toString() {
        return "TransacaoEntity{" +
                "transacaoId=" + transacaoId +
                ", valor=" + valor +
                ", efetivadaEm=" + efetivadaEm +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                '}';
    }
}
