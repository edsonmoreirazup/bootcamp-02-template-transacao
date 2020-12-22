package br.com.zup.nossocartao.transacao.transacaodocartao.repository;

import br.com.zup.nossocartao.transacao.transacaodocartao.entity.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoEntity, UUID> {

    Optional<CartaoEntity> findByCartaoId(UUID cartaoId);

}
