package lab04.transacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping(path = "api/transacao")
public class TransacaoController {
  
  private final TransacaoService transacaoService;

  @Autowired TransacaoController(TransacaoService transacaoService) {
    this.transacaoService = transacaoService;
  }

  @GetMapping
  public List<Transacao> getTransacoes() {
    return transacaoService.getTransacoes();
  }
}
