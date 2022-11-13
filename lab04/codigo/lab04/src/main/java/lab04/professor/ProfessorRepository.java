package lab04.professor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("SELECT p FROM Professor p WHERE p.email = ?1")
    Optional<Professor> findProfessorByEmail(String email);

    @Query("SELECT p FROM Professor p WHERE p.nome = ?1")
    Optional<Professor> findProfessorByNome(String nome);

    Professor findProfessorById(Long id);
}