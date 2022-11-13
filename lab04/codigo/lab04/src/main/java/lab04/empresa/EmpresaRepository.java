package lab04.empresa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("SELECT p FROM Empresa p WHERE p.email = ?1")
    Optional<Empresa> findEmpresaByEmail(String email);

    @Query("SELECT p FROM Empresa p WHERE p.nome = ?1")
    Optional<Empresa> findEmpresaByNome(String nome);

    Empresa findEmpresaById(Long id);
}