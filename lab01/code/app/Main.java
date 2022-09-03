package lab01.code.app;

import java.util.Scanner;

import lab01.code.business.Aluno;
import lab01.code.business.Disciplina;
import lab01.code.business.Financeiro;
import lab01.code.business.Professor;
import lab01.code.business.Secretaria;

// Questões pendentes:
// Encontrar aluno, professor, disciplina, etc...
// nextByte() ?

public class Main {

    static Secretaria secretaria = new Secretaria();

    // Sub menu do aluno

    public static void menuAluno() {
        System.out.println("Login Aluno");

        String choiceName;
        String choicePass;

        do {
            Scanner acesso;

            System.out.println("Digite seu nome: ");
            choiceName = acesso.nextLine();

            System.out.println("Digite sua senha: ");
            choicePass = acesso.nextLine();

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
                Disciplina disciplina;

                System.out.println("Insira a disciplina");
                disciplina = scan.nextByte();

                aluno.adicionarDisciplina(disciplina);

                break;

            case "3":
                Disciplina disciplinaMatricular;

                System.out.println("Insira a disciplina para matricular");
                disciplinaMatricular = scan.nextByte();

                aluno.matricular(disciplinaMatricular);

                break;
            case "4":

                Disciplina disciplinaCancelar;

                System.out.println("Insira a disciplina para cancelar");
                disciplinaCancelar = scan.nextByte();
                aluno.cancelarMatricula(disciplinaCancelar);
                break;

        }
    }

    // Sub menu do professor

    public static void menuProfessor() {
        System.out.println("Login Professor");

        String choiceName;
        String choicePass;

        do {
            System.out.println("Digite seu nome: ");
            Scanner sNome = new Scanner(System.in);
            choiceName = sNome.nextLine();

            System.out.println("Digite sua senha: ");
            Scanner sSenha = new Scanner(System.in);
            choicePass = sSenha.nextLine();

            professor.realizarLogin(choiceName, choicePass);

        } while (!professor.isAutenticado());

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

    public static void menuSecretaria() {

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

        switch (choice) {
            case "1":
                Scanner leitor = new Scanner(System.in);
                String nome;
                boolean obrigatoria;
                int cargaHoraria;
                Professor professor;
                int creditos;

                System.out.println("Insira o nome da disciplina");
                nome = leitor.nextLine();
                System.out.println("Status de obrigatoriedade (true/false)");
                obrigatoria = leitor.nextBoolean();
                System.out.println("Insira a carga horaria");
                cargaHoraria = leitor.nextInt();
                System.out.println("Insira o professor");
                professor = leitor.nextByte();
                System.out.println("Insira o numero de creditos");
                creditos = leitor.nextInt();

                secretaria.criarDisciplina(nome, obrigatoria, cargaHoraria, professor, creditos);

                break;

            case "2":
                String nomeCurso;
                int numCreditos;

                System.out.println("Insira o nome do curso");
                nome = leitor.nextLine();
                System.out.println("Insira a quantidade de creditos");
                creditos = leitor.nextInt();

                secretaria.criarCurso(nomeCurso, numCreditos);

                break;

            case "3":
                String nomeAluno;
                String senhaAluno;

                System.out.println("Insira o seu nome");
                nomeAluno = leitor.nextLine();
                System.out.println("Insira a sua senha");
                senhaAluno = leitor.nextLine();

                secretaria.cadastrarAluno(nome, senhaAluno);

                break;

            case "4":

                String nomeProfessor;
                String senhaProfessor;

                System.out.println("Insira o seu nome");
                nomeProfessor = leitor.nextLine();
                System.out.println("Insira a sua senha");
                senhaProfessor = leitor.nextLine();

                secretaria.cadastrarProfessor(nome, senha);

                break;

            case "5":

                Disciplina disciplina;

                System.out.println("Insira a disciplina");
                disciplina = leitor.nextByte();

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
                aluno = leitor.nextByte();

                financeiro.calcularCobranca(aluno);

                break;

            case "2":
                Aluno alunoCobranca;
                float valorFinal;;

                System.out.println("Insira o aluno");
                alunoCobranca = leitor.nextByte();
                System.out.println("Insira o valor final da cobranca");
                valorFinal = leitor.nextFloat();

                financeiro.enviarCobranca(alunoCobranca, valorFinal);

                break;

    }

    public static void main(String args[]) {

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
