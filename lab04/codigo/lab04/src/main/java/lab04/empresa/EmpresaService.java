package lab04.empresa;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getEmpresas() {
        return empresaRepository.findAll();
    }

    public void addEmpresa(Empresa empresa) {
        if (emailInUseValidation(empresa.getEmail())) {
            throw new IllegalStateException("Email em uso");
        }
        empresaRepository.save(empresa);
    }

    public void deleteEmpresa(long id) {
        if (!empresaRepository.existsById(id))
            throw new IllegalStateException("Não conseguimos encontrar um empresa com ID de valor " + id);
        empresaRepository.deleteById(id);
    }

    @Transactional
    public void updateEmpresa(long empresaId, String nome, String email) {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new IllegalStateException(
                        "Não conseguimos encontra o empresa com ID: " + empresaId));
        if (stringValidation(nome, empresa.getNome())) {
            empresa.setNome(nome);
        }
        if (stringValidation(email, empresa.getEmail())) {
            if (emailInUseValidation(email)) {
                throw new IllegalStateException("Email em uso ou inexitente");
            }
            empresa.setEmail(email);
        }
    }

    public boolean stringValidation(String toValid, String existing) {
        return (toValid != null && toValid.length() > 0 && !toValid.equals(existing));
    }

    public boolean emailInUseValidation(String email) {
        Optional<Empresa> empresaOptional = empresaRepository.findEmpresaByEmail(email);
        return (empresaOptional.isPresent());
    }

    public Empresa findEmpresaById(Long id) {
        return empresaRepository.findEmpresaById(id);
    }
}
