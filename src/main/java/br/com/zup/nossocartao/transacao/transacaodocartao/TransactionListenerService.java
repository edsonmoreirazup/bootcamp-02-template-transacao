package br.com.zup.nossocartao.transacao.transacaodocartao;

import br.com.zup.nossocartao.transacao.transacaodocartao.entity.CartaoEntity;
import br.com.zup.nossocartao.transacao.transacaodocartao.entity.TransacaoEntity;
import br.com.zup.nossocartao.transacao.transacaodocartao.repository.CartaoRepository;
import br.com.zup.nossocartao.transacao.transacaodocartao.repository.TransacaoRepository;
import br.com.zup.nossocartao.transacao.transacaodocartao.request.TransacaoCartaoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class TransactionListenerService {

    private CartaoRepository cartaoRepository;
    private TransacaoRepository transacaoRepository;
    private Logger logger = LoggerFactory.getLogger(TransactionListenerService.class);

    public TransactionListenerService(CartaoRepository cartaoRepository,
                                      TransacaoRepository transacaoRepository) {
        this.cartaoRepository = cartaoRepository;
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransacaoEvento transacaoEvento) {
        TransacaoCartaoRequest cartaoRequest = transacaoEvento.getCartao();
        Optional<CartaoEntity> optionalCard = cartaoRepository.findByCartaoId(cartaoRequest.getCartaoId());

        CartaoEntity cartao = optionalCard.orElse(new CartaoEntity(cartaoRequest.getCartaoId(), cartaoRequest.getEmail()));

        if(cartao.getCartaoId() == null) {
            cartaoRepository.save(cartao);
        }

        TransacaoEntity transacao = transacaoEvento.toModel(cartao);
        transacaoRepository.save(transacao);
        logger.info("Nova transação recebida: " + transacaoEvento);
    }

}