package br.com.zup.nossocartao.transacao.transacaodocartao.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "cartao")
public class CartaoEntity {

    @Id
    @Column(columnDefinition = "binary(16)")
    private UUID cartaoId;

    @NotBlank
    @Email
    private String email;

    @Deprecated
    public CartaoEntity() {
    }

    public CartaoEntity(@NotBlank UUID cartaoId, @NotBlank @Email String email) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartaoEntity)) return false;
        CartaoEntity that = (CartaoEntity) o;
        return cartaoId.equals(that.cartaoId) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartaoId, email);
    }

    @Override
    public String toString() {
        return "CartaoEntity{" +
                "cartaoId=" + cartaoId +
                ", email='" + email + '\'' +
                '}';
    }
}
