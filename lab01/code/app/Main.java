package lab01.code.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import lab01.code.business.Aluno;
import lab01.code.business.AutentificacaoException;
import lab01.code.business.Curso;
import lab01.code.business.CursoInexistenteException;
import lab01.code.business.Disciplina;
import lab01.code.business.Financeiro;
import lab01.code.business.Professor;
import lab01.code.business.Secretaria;

// Questões pendentes:
// Encontrar aluno, professor, disciplina, etc...

public class Main {

    static Secretaria secretaria = new Secretaria();

    // Sub menu do aluno

    public static void menuAluno() throws AutentificacaoException {
        System.out.println("Login Aluno");

        Aluno aluno;
        Map<String, Disciplina> disciplinaMap = new HashMap<>();
        String choiceName;
        String choicePass;

        do {
            Scanner acesso = new Scanner(System.in);

            System.out.println("Digite seu nome: ");
            choiceName = acesso.nextLine();

            System.out.println("Digite sua senha: ");
            choicePass = acesso.nextLine();

            for (int i = 0; i < secretaria.getAlunos().size(); i++) {
                if (secretaria.getAlunos().get(i).getNome().equals(choiceName)
                        && secretaria.getAlunos().get(i).getSenha().equals(choicePass)) {
                    aluno = secretaria.getAlunos().get(i);
                }
            }

            aluno.realizarLogin(choiceName, choicePass);

        } while (!aluno.isAutenticado());

        // Opções quando o aluno esta logado

        System.out.println(" SGA 2.0 - Aluno");
        System.out.println("1 - Mostrar dados");
        System.out.println("2 - Adicionar disciplina");
        System.out.println("3 - Matricular");
        System.out.println("4 - Cancelar matricula");

        String choice;

        System.out.println("Opcao : ");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextLine();

        switch (choice) {
            case "1":
                aluno.mostrarDados();
                break;
            case "2":

                System.out.println("Insira a disciplina");
                String input = scan.nextLine().toLowerCase();

                Disciplina disciplina = disciplinaMap.get(input);

                aluno.adicionarDisciplina(disciplina);

                break;

            case "3":

                System.out.println("Insira a disciplina para matricular");
                String inputMatricula = scan.nextLine().toLowerCase();

                Disciplina disciplinaMatricular = disciplinaMap.get(inputMatricula);

                aluno.matricular(disciplinaMatricular);

                break;
            case "4":

                System.out.println("Insira a disciplina para cancelar");
                String inputCancelar = scan.nextLine().toLowerCase();

                Disciplina disciplinaCancelar = disciplinaMap.get(inputCancelar);
                aluno.cancelarMatricula(disciplinaCancelar);
                
                break;

        }
    }

    // Sub menu do professor

    public static void menuProfessor() {
        System.out.println("Login Professor");

        Professor professor;
        String choiceName;
        String choicePass;

        do {
            Scanner acesso = new Scanner(System.in);

            System.out.println("Digite seu nome: ");
            choiceName = acesso.nextLine();

            System.out.println("Digite sua senha: ");
            choicePass = acesso.nextLine();

            for (int i = 0; i < secretaria.getProfessores().size(); i++) {
                if (secretaria.getProfessores().get(i).getNome().equals(choiceName)
                        && secretaria.getProfessores().get(i).getSenha().equals(choicePass)) {
                    professor = (Professor) secretaria.getProfessores().clone();
                }
            }

            professor.realizarLogin(choiceName, choicePass);

        } while (! professor.isAutenticado());

        // Opções quando o professor esta logado

        System.out.println(" SGA 2.0 - Professor");
        System.out.println("1 - Mostrar disciplinas");

        String choice;

        System.out.println("Opcao : ");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextLine();

        switch (choice) {
            case "1":
                professor.listarDisciplinas();
                break;

        }

    }

    // Sub menu da secretaria

    public static void menuSecretaria() throws CursoInexistenteException {

        // Opções secretaria

        System.out.println(" SGA 2.0 - Secretaria");
        System.out.println("1 - Criar disciplina ");
        System.out.println("2 - Criar curso ");
        System.out.println("3 - Cadastrar aluno ");
        System.out.println("4 - Cadastrar professor ");
        System.out.println("5 - Adicionar disciplina no semestre");

        String choice;

        System.out.println("Opcao : ");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextLine();

        Scanner leitor = new Scanner(System.in);

        switch (choice) {
            case "1":
                String nome;
                boolean obrigatoria;
                int cargaHoraria;
                Professor professor;
                int creditos;
                float custo;
                Curso curso;

                System.out.println("Insira o nome da disciplina");
                nome = leitor.nextLine();
                System.out.println("Status de obrigatoriedade (true/false)");
                obrigatoria = leitor.nextBoolean();
                System.out.println("Insira a carga horaria");
                cargaHoraria = leitor.nextInt();
                System.out.println("Insira o nome professor");
                String nomeProfessor = leitor.nextLine();

                for(int i = 0; i < secretaria.getProfessores().size(); i++){
                    if(secretaria.getProfessores().get(i).getNome().equals(nomeProfessor)){
                        professor = secretaria.getProfessores().get(i);
                    }
                }
                System.out.println("Insira o numero de creditos");
                creditos = leitor.nextInt();
                System.out.println("Insira o custo da disciplina");
                custo = leitor.nextFloat();
                System.out.println("Insira o nome do curso");
                String nomeCurso = leitor.nextLine();

                for(int i = 0; i < secretaria.getProfessores().size(); i++){
                    if(secretaria.getCursos().get(i).getNome().equals(nomeCurso)){
                        curso = secretaria.getCursos().get(i);
                    }
                }

                secretaria.criarDisciplina(nome, obrigatoria, cargaHoraria, professor, creditos, custo, curso);

                break;

            case "2":
                String nomeDoCurso;
                int numCreditos;

                System.out.println("Insira o nome do curso");
                nomeDoCurso = leitor.nextLine();
                System.out.println("Insira a quantidade de creditos");
                numCreditos = leitor.nextInt();

                secretaria.criarCurso(nomeDoCurso, numCreditos);

                break;

            case "3":
                String nomeAluno;
                String senhaAluno;

                System.out.println("Insira o seu nome");
                nomeAluno = leitor.nextLine();
                System.out.println("Insira a sua senha");
                senhaAluno = leitor.nextLine();

                secretaria.cadastrarAluno(nomeAluno, senhaAluno);

                break;

            case "4":

                String nomeDoProfessor;
                String senhaProfessor;

                System.out.println("Insira o seu nome");
                nomeDoProfessor = leitor.nextLine();
                System.out.println("Insira a sua senha");
                senhaProfessor = leitor.nextLine();

                secretaria.cadastrarProfessor(nomeDoProfessor, senhaProfessor);

                break;

            case "5":

                Disciplina disciplina;

                System.out.println("Insira o nome da disciplina");
                String nomeDisciplina = leitor.nextLine();

                for(int i = 0; i < secretaria.getCurriculoSemestre().size(); i++){
                    if(secretaria.getCurriculoSemestre().get(i).getNome().equals(nomeDisciplina)){
                        disciplina = secretaria.getCurriculoSemestre().get(i);
                    }
                }

                secretaria.addDisciplinaSemestre(disciplina);

        }

    }

    // Sub menu financeiro

    public static void menuFinanceiro() {
        System.out.println(" SGA 2.0 - Financeiro");
        System.out.println("1 - Calcular cobranca ");
        System.out.println("2 - Enviar cobranca ");


        String choice;

        System.out.println("Opcao : ");
        Scanner leitor = new Scanner(System.in);
        choice = leitor.nextLine();

        switch (choice) {
            case "1":
                Aluno aluno;

                System.out.println("Insira o aluno");
                String aluno2 = leitor.nextLine();
                for(int i = 0; i < secretaria.getAlunos().size(); i++){
                    if(secretaria.getAlunos().get(i).getNome().equals(aluno2)){
                        aluno = secretaria.getAlunos().get(i);
                    }

                }

                Financeiro.calcularCobranca(aluno);

                break;

            case "2":
                Aluno alunoCobranca;
                float valorFinal;;

                System.out.println("Insira o nome do aluno");
                String nomeAluno = leitor.nextLine();
                for(int i = 0; i < secretaria.getAlunos().size(); i++){
                    if(secretaria.getAlunos().get(i).getNome().equals(nomeAluno)){
                        alunoCobranca = secretaria.getAlunos().get(i);
                    }

                }
                System.out.println("Insira o valor final da cobranca");
                valorFinal = leitor.nextFloat();

                Financeiro.enviarCobranca(alunoCobranca, valorFinal);

                break;
            }
    }

    public static void main(String args[]) throws CursoInexistenteException, AutentificacaoException {

        System.out.println(" SGA 2.0");
        System.out.println("Entrar como: ");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Secretaria");
        System.out.println("4 - Financeiro");
        System.out.println("0 - Encerrar processo");

        String choice;

        do {
            System.out.println("Opcao : ");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();

            switch (choice) {
                case "1":
                    menuAluno();
                    break;
                case "2":
                    menuProfessor();
                    break;
                case "3":
                    menuSecretaria();
                    break;
                case "4":
                    menuFinanceiro();
                    break;

            }

        } while (choice.equals("0"));
    }
}
