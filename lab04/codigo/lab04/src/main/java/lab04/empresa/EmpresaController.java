package lab04.empresa;

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
@RequestMapping(path = "api/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<Empresa> getEmpresaes() {
        return empresaService.getEmpresas();
    }

    @PostMapping
    public void registerNewEmpresa(@RequestBody Empresa empresa) {
        empresaService.addEmpresa(empresa);
    }

    @GetMapping(path = "{empresaId}")
    public Empresa findempresaById(@PathVariable("empresaId") long id) {
        return empresaService.findEmpresaById(id);
    }

    @DeleteMapping(path = "{empresaId}")
    public void deleteEmpresa(@PathVariable("empresaId") long id) {
        empresaService.deleteEmpresa(id);
    }

    @PutMapping(path = "{empresaId}")
    public void updateEmpresa(@PathVariable("empresaId") long empresaId,
            @RequestParam(required = false) String nome, @RequestParam(required = false) String email) {
        empresaService.updateEmpresa(empresaId, nome, email);
    }

}
