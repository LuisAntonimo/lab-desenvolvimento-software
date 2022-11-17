package lab04.professor;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getProfessores() {
        return professorRepository.findAll();
    }

    public void addProfessor(Professor professor) {
        if (emailInUseValidation(professor.getEmail())) {
            throw new IllegalStateException("Email em uso");
        }
        professorRepository.save(professor);
    }

    public void deleteProfessor(long id) {
        if (!professorRepository.existsById(id))
            throw new IllegalStateException("Não conseguimos encontrar um professor com ID de valor " + id);
        professorRepository.deleteById(id);
    }

    @Transactional
    public void updateProfessor(long professorId, String nome, String email, String senha, String cpf, double saldo) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new IllegalStateException(
                        "Não conseguimos encontra o professor com ID: " + professorId));
        if (stringValidation(nome, professor.getNome())) {
            professor.setNome(nome);
        }
        if (stringValidation(email, professor.getEmail())) {
            if (emailInUseValidation(email)) {
                throw new IllegalStateException("Email em uso ou inexitente");
            }
            professor.setEmail(email);
        }
        if (stringValidation(senha, professor.getSenha())) {
            professor.setSenha(senha);
        }
        if (stringValidation(cpf, professor.getCpf())) {
            professor.setCpf(cpf);
        }
        professor.setSaldo(saldo);
    }

    public boolean stringValidation(String toValid, String existing) {
        return (toValid != null && toValid.length() > 0 && !toValid.equals(existing));
    }

    public boolean emailInUseValidation(String email) {
        Optional<Professor> professorOptional = professorRepository.findProfessorByEmail(email);
        return (professorOptional.isPresent());
    }

    public Professor findProfessorById(Long id) {
        return professorRepository.findProfessorById(id);
    }
}
