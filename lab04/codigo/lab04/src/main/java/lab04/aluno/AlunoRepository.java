package lab04.aluno;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT p FROM Aluno p WHERE p.cpf = ?1")
    Optional<Aluno> findAlunoByCpf(String cpf);

    @Query("SELECT p FROM Aluno p WHERE p.nome = ?1")
    Optional<Aluno> findAlunoByNome(String nome);

    Aluno findAlunoById(Long id);
}