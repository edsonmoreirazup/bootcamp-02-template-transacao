package br.com.zup.nossocartao.transacao.transacaodocartao.repository;

import br.com.zup.nossocartao.transacao.transacaodocartao.entity.TransacaoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransacaoRepository extends JpaRepository<TransacaoEntity, UUID> {

    List<TransacaoEntity> findAllByCartao_CartaoId(UUID cartaoId, Pageable pageable);

}
