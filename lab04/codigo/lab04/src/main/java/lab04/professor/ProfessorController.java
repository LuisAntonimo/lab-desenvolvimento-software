package lab04.professor;

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
@RequestMapping(path = "api/professor")
public class ProfessorController {

        private final ProfessorService professorService;

        @Autowired
        public ProfessorController(ProfessorService professorService) {
                this.professorService = professorService;
        }

        @GetMapping
        public List<Professor> getProfessores() {
                return professorService.getProfessores();
        }

        @PostMapping
        public void registerNewProfessor(@RequestBody Professor professor) {
                professorService.addProfessor(professor);
        }

        @GetMapping(path = "{professorId}")
        public Professor findProfessorById(@PathVariable("professorId") long id) {
                return professorService.findProfessorById(id);
        }

        @DeleteMapping(path = "{professorId}")
        public void deleteProfesor(@PathVariable("professorId") long id) {
                professorService.deleteProfessor(id);
        }

        @PutMapping(path = "{professorId}")
        public void updateProfessor(@PathVariable("professorId") long professorId,
                        @RequestParam(required = false) String nome, @RequestParam(required = false) String email,
                        @RequestParam(required = false) String senha,
                        @RequestParam(required = false) String cpf,
                        @RequestParam(required = false) double saldo) {
                professorService.updateProfessor(professorId, nome, email, senha, cpf, saldo);
        }

}
