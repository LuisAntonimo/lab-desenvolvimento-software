package lab04.aluno;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }

    public void addAluno(Aluno aluno) {
        if (cpfInUseValidation(aluno.getCpf())) {
            throw new IllegalStateException("cpf em uso");
        }
        alunoRepository.save(aluno);
    }

    public void deleteAluno(long id) {
        if (!alunoRepository.existsById(id))
            throw new IllegalStateException("Não conseguimos encontrar um aluno com ID de valor " + id);
        alunoRepository.deleteById(id);
    }

    @Transactional
    public void updateAluno(long alunoId, String nome, String email, String senha, String cpf, String rg, String curso,
            double saldo) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new IllegalStateException(
                        "Não conseguimos encontra o aluno com ID: " + alunoId));
        if (stringValidation(nome, aluno.getNome())) {
            aluno.setNome(nome);
        }
        if (stringValidation(email, aluno.getEmail())) {
            aluno.setEmail(email);
        }
        if (stringValidation(senha, aluno.getSenha())) {
            aluno.setSenha(senha);
        }
        if (stringValidation(cpf, aluno.getCpf())) {
            if (cpfInUseValidation(cpf)) {
                throw new IllegalStateException("cpf em uso ou inexitente");
            }
            aluno.setCpf(cpf);
        }
        if (stringValidation(rg, aluno.getRg())) {
            aluno.setRg(rg);
        }
        if (stringValidation(curso, aluno.getCurso())) {
            aluno.setCurso(curso);
        }
        if (saldo != aluno.getSaldo()) {
            aluno.setSaldo(saldo);// capaz de dar erro pq n pode receber null, aí é só trocar pra classe Double
        }
    }

    public boolean stringValidation(String toValid, String existing) {
        return (toValid != null && toValid.length() > 0 && !toValid.equals(existing));
    }

    public boolean cpfInUseValidation(String cpf) {
        Optional<Aluno> alunoOptional = alunoRepository.findAlunoByCpf(cpf);
        return (alunoOptional.isPresent());
    }

    public Aluno findAlunoById(Long id) {
        return alunoRepository.findAlunoById(id);
    }
}
