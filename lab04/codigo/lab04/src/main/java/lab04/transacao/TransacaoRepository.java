package lab04.transacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long>{
  Transacao findTransacaoById(Long id);
}
