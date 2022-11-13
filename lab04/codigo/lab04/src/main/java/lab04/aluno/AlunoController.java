package lab04.aluno;

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
@RequestMapping(path = "api/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> getAlunoes() {
        return alunoService.getAlunos();
    }

    @PostMapping
    public void registerNewAluno(@RequestBody Aluno aluno) {
        alunoService.addAluno(aluno);
    }

    @GetMapping(path = "{alunoId}")
    public Aluno findalunoById(@PathVariable("alunoId") long id) {
        return alunoService.findAlunoById(id);
    }

    @DeleteMapping(path = "{alunoId}")
    public void deleteAluno(@PathVariable("alunoId") long id) {
        alunoService.deleteAluno(id);
    }

    @PutMapping(path = "{alunoId}")
    public void updateAluno(@PathVariable("alunoId") long alunoId,
            @RequestParam(required = false) String nome, @RequestParam(required = true) String cpf,
            @RequestParam(required = true) String rg, @RequestParam(required = false) String curso,
            @RequestParam(required = false) double saldo) {
        alunoService.updateAluno(alunoId, nome, cpf, rg, curso, saldo);
    }

}
