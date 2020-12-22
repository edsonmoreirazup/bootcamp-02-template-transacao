package br.com.zup.nossocartao.transacao.transacaodocartao.request;

import br.com.zup.nossocartao.transacao.transacaodocartao.entity.CartaoEntity;
import br.com.zup.nossocartao.transacao.transacaodocartao.entity.TransacaoEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class TransacaoCartaoRequest {

    @NotBlank
    private UUID cartaoId;

    @NotBlank
    @Email
    private String email;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TransacaoCartaoRequest(@JsonProperty("id")@NotBlank UUID cartaoId, @NotBlank @Email String email) {
        this.cartaoId = cartaoId;
        this.email = email;
    }

    public UUID getCartaoId() {
        return cartaoId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "TransacaoCartaoRequest{" +
                "cartaoId=" + cartaoId +
                ", email='" + email + '\'' +
                '}';
    }
}
