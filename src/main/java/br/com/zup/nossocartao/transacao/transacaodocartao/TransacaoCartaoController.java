package br.com.zup.nossocartao.transacao.transacaodocartao;


import br.com.zup.nossocartao.transacao.transacaodocartao.entity.TransacaoEntity;
import br.com.zup.nossocartao.transacao.transacaodocartao.repository.TransacaoRepository;
import br.com.zup.nossocartao.transacao.transacaodocartao.response.TransacaoResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/cartoes")
public class TransacaoCartaoController {

    private TransacaoRepository transacaoRepository;

    public TransacaoCartaoController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping(path = "/{cartaoId}/transacaoes")
    public ResponseEntity<?> buscaUltimasTracaoesCartao(@PathVariable(name = "cartaoId") UUID cartaoId){
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "efetivadaEm"));
        List<TransacaoEntity> ultimasTransacaoes = transacaoRepository.findAllByCartao_CartaoId(cartaoId,pageable);

        List<TransacaoResponse> transacaoResponseList = ultimasTransacaoes.stream()
                .map(TransacaoResponse::fromModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(transacaoResponseList);
    }

}
