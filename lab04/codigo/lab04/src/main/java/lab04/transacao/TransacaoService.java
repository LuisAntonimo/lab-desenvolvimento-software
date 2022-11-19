package lab04.transacao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

  private final TransacaoRepository transacaoRepository;

  @Autowired
  public TransacaoService(TransacaoRepository transacaoRepository) {
    this.transacaoRepository = transacaoRepository;
  }

  public List<Transacao> getTransacoes() {
    return transacaoRepository.findAll();
  }
  
}
