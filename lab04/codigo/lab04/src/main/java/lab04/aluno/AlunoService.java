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
        if (emailInUseValidation(aluno.getEmail())) {
            throw new IllegalStateException("Email em uso");
        }
        alunoRepository.save(aluno);
    }

    public void deleteAluno(long id) {
        if (!alunoRepository.existsById(id))
            throw new IllegalStateException("Não conseguimos encontrar um aluno com ID de valor " + id);
        alunoRepository.deleteById(id);
    }

    @Transactional
    public void updateAluno(long alunoId, String nome, String email) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new IllegalStateException(
                        "Não conseguimos encontra o aluno com ID: " + alunoId));
        if (stringValidation(nome, aluno.getNome())) {
            aluno.setNome(nome);
        }
        if (stringValidation(email, aluno.getEmail())) {
            if (emailInUseValidation(email)) {
                throw new IllegalStateException("Email em uso ou inexitente");
            }
            aluno.setEmail(email);
        }
    }

    public boolean stringValidation(String toValid, String existing) {
        return (toValid != null && toValid.length() > 0 && !toValid.equals(existing));
    }

    public boolean emailInUseValidation(String email) {
        Optional<Aluno> alunoOptional = alunoRepository.findAlunoByEmail(email);
        return (alunoOptional.isPresent());
    }

    public Aluno findAlunoById(Long id) {
        return alunoRepository.findAlunoById(id);
    }
}
